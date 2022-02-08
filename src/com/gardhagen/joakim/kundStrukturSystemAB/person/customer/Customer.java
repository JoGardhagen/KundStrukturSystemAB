package com.gardhagen.joakim.kundStrukturSystemAB.person.customer;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;

public class Customer extends Person {

	@Override
	public String toString() {
		return "[id=" + id + ", forName=" + forName + ", lastName=" + lastName + ", Adress=" + Adress + "]";
	}

	public Customer(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		
	}

}
