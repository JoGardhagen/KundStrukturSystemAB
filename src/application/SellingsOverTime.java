package application;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SellingsOverTime {
	public SellingsOverTime(Seller seller) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : " + seller.getForName() +" "+ seller.getLastName());
		StackPane layout = new StackPane();
		
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Seller :"+seller.toString());
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Sellings");
		
		@SuppressWarnings("rawtypes")
		LineChart lineChart = new LineChart(xAxis,yAxis);
		
		layout.getChildren().add(lineChart);
		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
	public SellingsOverTime(Article article) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : "+article.pruductName+ " ");
		StackPane layout = new StackPane();

		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
	public SellingsOverTime(Customer customer) {
		Stage sellings = new Stage();
		sellings.setTitle(" Buyings From : "+customer.getForName() +" "+customer.getLastName()+" "+customer.getAdress());
		StackPane layout = new StackPane();

		
		Scene scene = new Scene(layout,600,400);
		sellings.setScene(scene);
		sellings.show();
	}
}
