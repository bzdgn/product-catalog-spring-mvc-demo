package com.levent.pcd.utils;

import java.util.List;

import com.levent.pcd.model.ShoppingCartEntry;

public interface PriceStrategy {
	
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries);
	
}
