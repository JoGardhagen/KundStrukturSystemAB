package com.gardhagen.joakim.kundStrukturSystemAB.person.customer;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CustomersBuyings {
	
	public CustomersBuyings(Customer customer) {
		Stage customerBuyings = new Stage();
		customerBuyings.setTitle(customer.getForName()+ " "+ customer.getLastName() + " has bought :");
		StackPane layout = new StackPane();
		ListView<String> listview = new ListView<>();
		addCustomersBuyingList(customer, listview);// Populerar Listan som visas p? sk?rmen 
		layout.getChildren().add(listview);
		Scene scene = new Scene(layout,600,400);
		customerBuyings.setScene(scene);
		customerBuyings.show();
	}
	void addCustomersBuyingList(Customer customer,ListView<String> listview) {
		int total = 0;
		float spent = 0f;
		for(String s : customer.bought) {
			listview.getItems().add(s);
			String split[] = s.split(" ");
			String value = split[0];
			String saldo = split[16];
			spent +=Float.parseFloat(saldo);
			total +=Integer.parseInt(value);
		}
		listview.getItems().add("Total bought = "+ total +" items" +" for subtotal of " +spent);
		}
	
}
