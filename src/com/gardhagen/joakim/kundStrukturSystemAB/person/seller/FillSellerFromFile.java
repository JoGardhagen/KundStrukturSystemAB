package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FillSellerFromFile {
	String filePath = "StaffMember.txt";
	public FillSellerFromFile(List<Seller> sellerList ) {
		try(BufferedReader fReader = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = fReader.readLine())!=null) {
				String split[] = line.split(" ");
				String fName = split[0];
				String lName = split[1];
				String adresspart1 = split[2];
				String adresspart2 = split[3];
				String adress = adresspart1 +" "+ adresspart2;
				
				Seller seller = new Seller(0, fName, lName, adress );
				sellerList.add(seller);
				
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
