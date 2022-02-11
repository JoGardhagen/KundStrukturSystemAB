package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.util.Collections;
import java.util.List;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;

public class FillSellersCostumerList {
	public FillSellersCostumerList(List<Seller>sellers,List<Customer>customers) {
		Collections.shuffle(customers);
//		List<Customer> sublist1 = customers.subList(0, (customers.size()/3));
//		List<Customer> sublist2 = customers.subList((customers.size()/3), (customers.size()/2));
//		List<Customer> sublist3 = customers.subList((customers.size()/2), customers.lastIndexOf(customers));
//		sellers.get(0).sellersCustomerList.addAll(sublist1);
//		sellers.get(1).sellersCustomerList.addAll(sublist2);
//		sellers.get(2).sellersCustomerList.addAll(sublist3);
//		sellers.get(0).addToSellerCustomerList(customers.get(0));
		List<Customer> sublist1 = customers.subList(0, (customers.size()/3));
		List<Customer> sublist2 = customers.subList((customers.size()/3), (customers.size()/2));
//		List<Customer> sublist3 = customers.subList((customers.size()/2), customers.lastIndexOf(customers));
		sellers.get(0).sellersCustomerList.addAll(sublist1);
		sellers.get(1).sellersCustomerList.addAll(sublist2);
//		sellers.get(2).sellersCustomerList.addAll(sublist3);
//		for(Seller seller : sellers) {
//			Collections.shuffle(customers);
//			seller.sellersCustomerList.add(customers.get(0));
//			
//			
//		}
	}
}
