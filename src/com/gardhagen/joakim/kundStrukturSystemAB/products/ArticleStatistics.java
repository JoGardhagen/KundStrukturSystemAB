package com.gardhagen.joakim.kundStrukturSystemAB.products;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ArticleStatistics {
	public ArticleStatistics(Article article) {
		Stage articleStatistics = new Stage();
		articleStatistics.setTitle(article.artNumber + " " + article.pruductName);
		StackPane layout = new StackPane();
		ListView<String> listview = new ListView<>();
		addArticlesForToListview(article,listview);
		layout.getChildren().add(listview);
		Scene scene = new Scene(layout,600,400);
		articleStatistics.setScene(scene);
		articleStatistics.show();
	}

	private void addArticlesForToListview(Article article, ListView<String> listview) {
		int total = 0;
		for(String s:article.sold) {
			listview.getItems().add(s);
			String split[] = s.split(" ");
			String value = split[0];
			total +=Integer.parseInt(value);
		}
		listview.getItems().add("Total sold = "+ total);
	}
}
