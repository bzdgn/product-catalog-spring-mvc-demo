package com.levent.pcd.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.levent.pcd.model.ShoppingCartEntry;
import com.levent.pcd.model.ShoppingCartMap;

/*
 * Additional top layer for business logic
 * Call Service Layers
 */
@Service
public interface ShoppingHandler {
	
	public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap);
	public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries);
	public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries);
	
}
