package com.gardhagen.joakim.kundStrukturSystemAB.timeStamp;

public class IdNumber {
	private static IdNumber instance;
	static int incrementID;
	private IdNumber() {
		incrementID++;
	}
	public static IdNumber getInstance() {
		if(instance == null) {
			instance = new IdNumber();
		}
		return instance;
	}
	
	
}
