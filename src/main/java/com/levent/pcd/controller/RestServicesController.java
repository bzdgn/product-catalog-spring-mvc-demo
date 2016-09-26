package com.levent.pcd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.levent.pcd.model.Product;
import com.levent.pcd.model.ShoppingCartMap;
import com.levent.pcd.service.CategoryService;
import com.levent.pcd.service.ProductService;

@RestController
@RequestMapping(value = "/services")
public class RestServicesController {
	
	// services
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	// session scoped POJOs
	
	@Autowired
	private ShoppingCartMap shoppingCartMap;
	
	// endpoints
	@RequestMapping("/addToCart")
	public void addToCart(
			@RequestParam(value = "productCode") String productCode, 
			@RequestParam(value = "quantity") int quantity
	) {
		shoppingCartMap.addItem(productCode, quantity);
	}
	
	
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET)
	public List<String> getCategories() {
		return categoryService.findAll();
	}
	
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productService.findAll();
	}
	
	@RequestMapping(value = "/getProductByProductCode/{productCode}", method = RequestMethod.GET)
	public @ResponseBody Product getProductByProductCode(@PathVariable String productCode) {
		return productService.findByProductCode(productCode);
	}
	
	@RequestMapping(value = "/getProductsByCategories/{categoryName}", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductById(@PathVariable String categoryName) {
		return productService.findProductsByCategory(categoryName);
	}
	
}