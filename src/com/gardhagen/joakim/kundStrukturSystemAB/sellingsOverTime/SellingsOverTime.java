package com.gardhagen.joakim.kundStrukturSystemAB.sellingsOverTime;

import com.gardhagen.joakim.kundStrukturSystemAB.person.customer.Customer;
import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import com.gardhagen.joakim.kundStrukturSystemAB.products.Article;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SellingsOverTime {
	// Deklarerar X o Y axlarna här för att nås i alla 3 Konstruktorer
	NumberAxis xAxis = new NumberAxis();
	NumberAxis yAxis = new NumberAxis();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	LineChart lineChart = new LineChart(xAxis, yAxis);
	@SuppressWarnings("rawtypes")
	XYChart.Series dataSeries = new XYChart.Series();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SellingsOverTime(Seller seller) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : " + seller.getForName() + " " + seller.getLastName());
		StackPane layout = new StackPane();
		xAxis.setLabel("Seller :" + seller.toString());
		yAxis.setLabel("Earning ");

		try {
			
		
//		CollectDataSeries dataSeries = new CollectDataSeries(seller.activityList);
		String date = " ";
		dataSeries.getData().add(new XYChart.Data(0, 0 ));
		for (String dataString : seller.activityList) {
			String dataSlpit[] = dataString.split(" ");
			String units = dataSlpit[0];
			String earnings = dataSlpit[16];
			System.out.println(units);
			date = dataSlpit[18];
			System.out.println(date);
			String time = dataSlpit[20];
			System.out.println(time);
			String timeSplit[] = time.split(":");
			String hh = timeSplit[0];
			System.out.println(hh);
			String mins = timeSplit[1];
			System.out.println(mins);
			String secs = timeSplit[2];
			System.out.println(secs);
//			String timeFrame = hh + mins + secs;
			String timeFrame = ""+secs;
			System.out.println(timeFrame);
//			String timeFrame = "2000";
			float earningsTofloat = Float.parseFloat(earnings);
			int timeToInt = Integer.parseInt(timeFrame);
			int	unitsToInt = Integer.parseInt(units);
			System.out.println(timeToInt + " "+unitsToInt);
			dataSeries.getData().add(new XYChart.Data(timeToInt, earningsTofloat ));
			dataSeries.setName(date.toString());
		}
		
		} catch (Exception e) {
			
			System.out.println(e);
		}
		lineChart.getData().add(dataSeries);
		layout.getChildren().add(lineChart);

		Scene scene = new Scene(layout, 600, 400);
		sellings.setScene(scene);
		sellings.show();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SellingsOverTime(Article article) {
		Stage sellings = new Stage();
		sellings.setTitle("Sellings : " + article.pruductName + " ");
		StackPane layout = new StackPane();
		xAxis.setLabel("Seller :" + article.toString());
		yAxis.setLabel("units sold");
		
		try {
			
			
//			CollectDataSeries dataSeries = new CollectDataSeries(seller.activityList);
			String date = " ";
			
			dataSeries.getData().add(new XYChart.Data(0, 0 ));
			for (String dataString : article.sold) {
				String dataSlpit[] = dataString.split(" ");
				String units = dataSlpit[0];
				System.out.println(units);
				date = dataSlpit[18];
				System.out.println(date);
				String time = dataSlpit[20];
				System.out.println(time);
				String timeSplit[] = time.split(":");
				String hh = timeSplit[0];
				System.out.println(hh);
				String mins = timeSplit[1];
				System.out.println(mins);
				String secs = timeSplit[2];
				System.out.println(secs);
				String timeFrame = secs;
				System.out.println(timeFrame);
				int timeToInt = Integer.parseInt(timeFrame);
				int	unitsToInt = Integer.parseInt(units);
				System.out.println(timeToInt + " "+unitsToInt);
				dataSeries.getData().add(new XYChart.Data(timeToInt, unitsToInt ));
			}
			dataSeries.setName(date);
			} catch (Exception e) {
				
				System.out.println(e);
			}
			lineChart.getData().add(dataSeries);
			layout.getChildren().add(lineChart);

		
		layout.getChildren().add(lineChart);

		Scene scene = new Scene(layout, 600, 400);
		sellings.setScene(scene);
		sellings.show();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SellingsOverTime(Customer customer) {
		Stage sellings = new Stage();
		sellings.setTitle(
				" Buyings From : " + customer.getForName() + " " + customer.getLastName() + " " + customer.getAdress());
		StackPane layout = new StackPane();
		xAxis.setLabel("Customer :" + customer.toString());
		yAxis.setLabel("units bougt");
		
		try {
			
			
//			CollectDataSeries dataSeries = new CollectDataSeries(seller.activityList);
			String date = " ";
			dataSeries.getData().add(new XYChart.Data(0, 0 ));
			for (String dataString : customer.bought) {
				String dataSlpit[] = dataString.split(" ");
				String units = dataSlpit[0];
				System.out.println(units);
				date = dataSlpit[18];
				System.out.println(date);
				String time = dataSlpit[20];
				System.out.println(time);
				String timeSplit[] = time.split(":");
				String hh = timeSplit[0];
				System.out.println(hh);
				String mins = timeSplit[1];
				System.out.println(mins);
				String secs = timeSplit[2];
				System.out.println(secs);
				String timeFrame = hh+ mins + secs;
				System.out.println(timeFrame);
//				String timeFrame = "2000";
				int timeToInt = Integer.parseInt(timeFrame);
				int	unitsToInt = Integer.parseInt(units);
				System.out.println(timeToInt + " "+unitsToInt);
				dataSeries.getData().add(new XYChart.Data(timeToInt, unitsToInt ));
			}
			dataSeries.setName(date);
			} catch (Exception e) {
				
				System.out.println(e);
			}
			lineChart.getData().add(dataSeries);
			layout.getChildren().add(lineChart);

		
		layout.getChildren().add(lineChart);

		Scene scene = new Scene(layout, 600, 400);
		sellings.setScene(scene);
		sellings.show();
	}
}
