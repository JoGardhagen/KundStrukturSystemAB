package com.gardhagen.joakim.kundStrukturSystemAB.person.customer;

import java.util.ArrayList;
import java.util.List;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;

public class Customer extends Person {
	public List<String> bought = new ArrayList<>();
	@Override
	public String toString() {
		return "[id=" + id + ", " + forName + " " + lastName + ", " + Adress + "]";
	}

	public Customer(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		
	}

}
