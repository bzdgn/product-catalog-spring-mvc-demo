package com.levent.pcd.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartMap {
	
	int itemCount;
	Map<String, Integer> cartItems;
	
	public ShoppingCartMap() {
		itemCount = 0;
		cartItems = new HashMap<>();
	}
	
	public void addItem(String productCode, int quantity) {
		if(!cartItems.containsKey(productCode))
			cartItems.put(productCode, quantity);
		else {
			cartItems.put(productCode, cartItems.get(productCode)+quantity);
		}
		
		itemCount += quantity;
	}

	public Map<String, Integer> getCartItems() {
		return cartItems;
	}
	
	public int getQuantity(String productCode) {
		return cartItems.get(productCode);
	}
	
	public int getItemSize() {
		return itemCount;
	}
	
}
