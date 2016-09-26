package com.levent.pcd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.levent.pcd.business.ShoppingHandler;
import com.levent.pcd.model.Product;
import com.levent.pcd.model.ShoppingCartEntry;
import com.levent.pcd.model.ShoppingCartMap;
import com.levent.pcd.service.CategoryService;
import com.levent.pcd.service.ProductService;

@Controller
public class FrontController {
	
	// services
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ShoppingHandler shoppingHandler;
	
	// session scoped POJOs
	
	@Autowired
	private ShoppingCartMap shoppingCartMap;
	
	@RequestMapping(value = "/products")
	public ModelAndView listProducts() {
		
		List<String> categories = categoryService.findAll();
		List<Product> products = productService.findAll();
		
		ModelAndView model = new ModelAndView("products");
		
		model.addObject("productList", products);
		model.addObject("categoryList", categories);
		
		return model;
	}
	
	/*
	 * Product with search string
	 */
	@RequestMapping(value = "/products", params="srch-term")
	public ModelAndView listProductsByNameSearch(@RequestParam("srch-term") String searchTerm) {
		List<Product> products = productService.findProductsByName(searchTerm);
		List<String> categories = categoryService.findAll();
		
		ModelAndView model = new ModelAndView("products");
		
		model.addObject("categoryList", categories);
		model.addObject("productList", products);
		
		return model;
	}
	
	@RequestMapping(value = "/products-by-category-{categoryName}")
	public ModelAndView listProductsByCategory(@PathVariable("categoryName") String categoryName) {
		List<Product> products = productService.findProductsByCategory(categoryName);
		List<String> categories = categoryService.findAll();
		
		ModelAndView model = new ModelAndView("products");
		
		model.addObject("categoryList", categories);
		model.addObject("productList", products);
		
		return model;
	}
	
	@RequestMapping(value = "/product-details-{productCode}")
	public ModelAndView listProductById(@PathVariable("productCode") String productCode) {
		
		Product product = productService.findByProductCode(productCode);
		
		ModelAndView model = new ModelAndView("product-details");
		model.addObject("product", product);
		model.addObject("shoppingCartMap", shoppingCartMap);
		
		return model;
	}
	
	@RequestMapping(value = "/shopping-cart")
	public ModelAndView shoppingCart() {
		ModelAndView model = new ModelAndView("shopping-cart");
		
		List<ShoppingCartEntry> shoppingCartEntries = shoppingHandler.getShoppingCartEntries(shoppingCartMap);
		
		model.addObject("shoppingCartEnries", shoppingCartEntries);
		model.addObject("shoppingItemSize", shoppingCartMap.getItemSize());
		model.addObject("totalPrice", shoppingHandler.getTotalPrice(shoppingCartEntries));
		model.addObject("taxPrice", shoppingHandler.getTotalTax(shoppingCartEntries));
		
		return model;
	}
	
}