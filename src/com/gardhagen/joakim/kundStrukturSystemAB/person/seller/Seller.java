package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import com.gardhagen.joakim.kundStrukturSystemAB.person.Person;
import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;

public class Seller extends Person {
	public List <String> activityList = new ArrayList<>();
	public List <Customer> sellersCustomerList = new ArrayList<>();
	private PropertyChangeSupport propertyChangeSuport;
	private boolean commonCustomer = false;
	public boolean isCommonCustomer() {
		return commonCustomer;
	}
	public void setCommonCustomer(boolean commonCustomer) {
		this.commonCustomer = commonCustomer;
		this.propertyChangeSuport.firePropertyChange(forName, isCommonCustomer(), isCommonCustomer());// tillhör observerMönster
	}
	@Override
	public String toString() {
		return "[id=" + id + ", " + forName + ", " + lastName + ", " + Adress + "]";
	}
	public Seller(int id, String forName, String lastName, String adress) {
		super(id, forName, lastName, adress);
		this.propertyChangeSuport = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSuport.addPropertyChangeListener(listener);
	}
	public void addToSellerCustomerList(Customer customer) {
		sellersCustomerList.add(customer);
	}
//	public void printActivityList() {
//		System.out.println( this.forName +" "+this.lastName +"\n");
//		for(String activty:activityList) {
//			System.out.println(activty);
//		}
//	}
////	public void noteUpdate() { 
//		activityList.as
//	}
//	


}
