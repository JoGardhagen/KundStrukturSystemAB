package com.gardhagen.joakim.kundStrukturSystemAB.sellingsOverTime;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SellingsOverTime {
	// Deklarerar X o Y axlarna här för att nås i alla 3 Konstruktorer 
	NumberAxis xAxis = new NumberAxis();
	NumberAxis yAxis = new NumberAxis();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	LineChart lineChart = new LineChart(xAxis,yAxis);
	public SellingsOverTime(Seller seller) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : " + seller.getForName() +" "+ seller.getLastName());
		StackPane layout = new StackPane();
		
		
		xAxis.setLabel("Seller :"+seller.toString());
		
		
		yAxis.setLabel("Earning ");
		
		
		
		layout.getChildren().add(lineChart);
		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
	public SellingsOverTime(Article article) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : "+article.pruductName+ " ");
		StackPane layout = new StackPane();
		
		
		xAxis.setLabel("Seller :"+article.toString());
		
		
		yAxis.setLabel("units sold");
		
		
		
		layout.getChildren().add(lineChart);
		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
	public SellingsOverTime(Customer customer) {
		Stage sellings = new Stage();
		sellings.setTitle(" Buyings From : "+customer.getForName() +" "+customer.getLastName()+" "+customer.getAdress());
		StackPane layout = new StackPane();

		
		xAxis.setLabel("Customer :"+customer.toString());
		
		
		yAxis.setLabel("units bougt");
		
		
		layout.getChildren().add(lineChart);
		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
}
