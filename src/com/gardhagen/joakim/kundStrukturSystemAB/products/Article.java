package com.gardhagen.joakim.kundStrukturSystemAB.products;

import java.util.ArrayList;
import java.util.List;

public class Article {
	
	public int artNumber;
	public String pruductName;
	public float price;
	public List<String> sold = new ArrayList<>();
	@Override
	public String toString() {
		return " [ " + artNumber + ", " + pruductName + ", " + price + " .SEK:-";
	}
	
	
}
