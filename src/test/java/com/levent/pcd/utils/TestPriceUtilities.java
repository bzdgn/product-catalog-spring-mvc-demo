package com.levent.pcd.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import com.levent.pcd.utils.PriceUtilities;

public class TestPriceUtilities {
	
	@Test
	public void priceUtilityConvertsCeilingRoundedDouble() {
		double value = 5.98321;
		
		String output = PriceUtilities.roundToTwoDecimalPlaces(value);
		assertEquals(output, "5.98");
	}
	
	@Test
	public void priceUtilityConvertsFloowRoundedDouble() {
		double value = 5.91234;
		
		String output = PriceUtilities.roundToTwoDecimalPlaces(value);
		assertEquals(output, "5.91");
	}

}
