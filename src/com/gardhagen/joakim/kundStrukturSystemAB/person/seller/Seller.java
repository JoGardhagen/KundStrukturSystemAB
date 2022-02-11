package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.util.ArrayList;
import java.util.List;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;

public class Seller extends Person {
	public List <String> activityList = new ArrayList<>();
	public List <Customer> sellersCustomerList = new ArrayList<>();
	@Override
	public String toString() {
		return "[id=" + id + ", " + forName + ", " + lastName + ", " + Adress + "]";
	}
	public Seller(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		
	}
	public void addToSellerCustomerList(Customer customer) {
		sellersCustomerList.add(customer);
	}
	public void printActivityList() {
		System.out.println( this.forName +" "+this.lastName +"\n");
		for(String activty:activityList) {
			System.out.println(activty);
		}
	}
	


}
