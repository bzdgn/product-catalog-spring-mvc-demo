package com.levent.pcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levent.pcd.model.Product;
import com.levent.pcd.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findByProductCode(String productCode) {
		return productRepository.findByProductCode(productCode);
	}
	
	@Override
	public List<Product> findProductsByCategory(String categoryName) {
		return productRepository.findProductsByCategory(categoryName);
	}

	@Override
	public List<Product> findProductsByName(String searchString) {
		return productRepository.findProductsByProductNameRegex(searchString);
	}
	
}
