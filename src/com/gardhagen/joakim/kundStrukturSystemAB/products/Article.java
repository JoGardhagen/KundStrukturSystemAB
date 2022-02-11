package com.gardhagen.joakim.kundStrukturSystemAB.products;

public class Article {
	
	public int artNumber;
	public String pruductName;
	public float price;
	@Override
	public String toString() {
		return " [ " + artNumber + ", " + pruductName + ", " + price + " .SEK:-";
	}
	
	
}
