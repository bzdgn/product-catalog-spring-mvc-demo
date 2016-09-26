package com.levent.pcd.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levent.pcd.model.Product;
import com.levent.pcd.model.ShoppingCartEntry;
import com.levent.pcd.model.ShoppingCartMap;
import com.levent.pcd.service.ProductService;
import com.levent.pcd.utils.PriceStrategy;
import com.levent.pcd.utils.PriceStrategyRaw;
import com.levent.pcd.utils.PriceStrategyTax;
import com.levent.pcd.utils.PriceUtilities;

@Component
public class ShoppingHandlerImpl implements ShoppingHandler {
	
	@Autowired
	private ProductService productService;
	
	private PriceStrategy priceHandler;
	
	@Override
	public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) {
		List<ShoppingCartEntry> shoppingCarts = new ArrayList<>();
		
		for(String productCode : shoppingCartMap.getCartItems().keySet() ) {
			Product p = productService.findByProductCode(productCode);
			
			ShoppingCartEntry s = new ShoppingCartEntry();
			
			int quantity = shoppingCartMap.getQuantity(productCode);
			
			s.setImageUrl(p.getImageUrl());
			s.setProductName(p.getProductName());
			s.setPrice(p.getPrice());
			s.setProductTotalPrice( p.getPrice() * quantity );
			s.setQuantity(quantity);
			
			shoppingCarts.add(s);
		}
		
		return shoppingCarts;
	}

	@Override
	public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyRaw();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}

	@Override
	public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyTax();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}
	
}
