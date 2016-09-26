package com.levent.pcd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.levent.pcd.model.Product;

/*
 * Service Layer should be used for Transactional processes
 * 
 * Calls Repository Layers
 * 
 */
@Service
public interface ProductService {
	
	public List<Product> findAll();
	public Product findByProductCode(String productCode);
	public List<Product> findProductsByCategory(String categoryName);
	public List<Product> findProductsByName(String searchString);
	
}
