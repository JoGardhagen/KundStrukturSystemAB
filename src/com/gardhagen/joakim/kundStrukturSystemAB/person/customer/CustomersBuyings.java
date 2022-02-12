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
		addCustomersBuyingList(customer, listview);
		layout.getChildren().add(listview);
		Scene scene = new Scene(layout,600,400);
		customerBuyings.setScene(scene);
		customerBuyings.show();
	}
	void addCustomersBuyingList(Customer customer,ListView<String> listview) {
		int total = 0;
		for(String s : customer.bought) {
			listview.getItems().add(s);
			String split[] = s.split(" ");
			String value = split[0];
			total +=Integer.parseInt(value);
		}
		listview.getItems().add("Total bought = "+ total +" items");
		}
	
}
