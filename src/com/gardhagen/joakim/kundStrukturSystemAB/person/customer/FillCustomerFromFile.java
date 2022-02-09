package com.gardhagen.joakim.kundStrukturSystemAB.person.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FillCustomerFromFile {
	String filePath = "PersonList.txt";
	public FillCustomerFromFile(List<Customer> custemerList) {
		try(BufferedReader fReader = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = fReader.readLine())!=null) {
				String split[] = line.split(" ");
				String fName = split[0];
				String lName = split[1];
				String adresspart1 = split[2];
				String adresspart2 = split[3];
				String adress = adresspart1 +" "+ adresspart2;
				
				Customer customer = new Customer(0, fName, lName, adress );
				custemerList.add(customer);
				
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
