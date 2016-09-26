package com.levent.pcd.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.levent.pcd.model.ShoppingCartEntry;

public class TestPriceStrategy {
	
	private static PriceStrategy priceStrategy;
	private static List<ShoppingCartEntry> shoppingCartEntries;
	
    @BeforeClass
    public static void runOnceBeforeClass() {
        shoppingCartEntries = new ArrayList<>();
        
        ShoppingCartEntry e1 = new ShoppingCartEntry();
        e1.setPrice(15.32);
        e1.setQuantity(2);
        e1.setProductTotalPrice(30.64);
        
        shoppingCartEntries.add(e1);
        
        ShoppingCartEntry e2 = new ShoppingCartEntry();
        e2.setPrice(24.01);
        e2.setQuantity(1);
        e2.setProductTotalPrice(24.01);
        
        shoppingCartEntries.add(e2);
        
        // total raw price: 54.65
    }
	
	@Test
	public void priceStrategyRawReturnsPrice() {
		priceStrategy = new PriceStrategyRaw();
		
		assertEquals( 54.65, priceStrategy.getTotal(shoppingCartEntries), 0.0001);
	}
	
	@Test
	public void PriceStrategyTaxReturnsTax() {
		priceStrategy = new PriceStrategyTax();
		
		assertEquals( 9.837, priceStrategy.getTotal(shoppingCartEntries), 0.0001);
	}

}
