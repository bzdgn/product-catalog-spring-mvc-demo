package com.levent.pcd.utils;

/*
 * Helper Class for static basic String operations
 */
public class PriceUtilities {
	
	// helper method for rounding double value to two decimal places
	public static String roundToTwoDecimalPlaces(double value) {
		return Double.toString(roundToNDecimalPlaces(value, 2));
	}
	
	// helper method for rounding double value to N decimal places
	// refer to SO solution: http://stackoverflow.com/a/2808648/3128926
	private static double roundToNDecimalPlaces(double value, int n) {
		long factor = (long)Math.pow(10, n);
		value = value * factor;
		long temp = Math.round(value);
		return (double) temp/factor;
	}
	
}
