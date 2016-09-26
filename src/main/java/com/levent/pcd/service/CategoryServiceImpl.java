package com.levent.pcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levent.pcd.repository.CategoryRepository;

@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<String> findAll() {
		return categoryRepository.findAll();
	}
	


}
