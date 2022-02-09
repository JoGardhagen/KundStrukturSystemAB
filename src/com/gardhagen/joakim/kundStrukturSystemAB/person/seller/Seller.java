package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.util.ArrayList;
import java.util.List;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;

public class Seller extends Person {
	List <Customer> sellersCustomer = new ArrayList<>();
	@Override
	public String toString() {
		return "[id=" + id + ", " + forName + ", " + lastName + ", " + Adress + "]";
	}
	public Seller(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		
	}


}
