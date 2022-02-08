package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;

public class Seller extends Person {
	
	@Override
	public String toString() {
		return "[id=" + id + ", forName=" + forName + ", lastName=" + lastName + ", Adress=" + Adress + "]";
	}
	public Seller(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		
	}


}
