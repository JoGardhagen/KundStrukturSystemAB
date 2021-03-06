package com.gardhagen.joakim.kundStrukturSystemAB.sellingsOverTime;

import com.gardhagen.joakim.kundStrukturSystemAB.person.seller.Seller;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//Kunder och arttiklar fungaerar inte. . .

public class SellingsOverTime {
	// Deklarerar X o Y axlarna h?r f?r att n?s i alla 3 Konstruktorer
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
			
		
// s? jag f?r det att fungera ?r att jag spara sekunderna och det ?r de som skrivs ut i grafen
			// system.out.printLn ?r bara f?r fels?kandet
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

			String timeFrame = ""+secs;
			System.out.println(timeFrame);

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

}
