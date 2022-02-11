package com.gardhagen.joakim.kundStrukturSystemAB.products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FillPruductList {
	String filePath = "Articles.txt";
	public FillPruductList(List<Article> pruductList) {

		try (BufferedReader fReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = fReader.readLine()) != null) {
				String split[] = line.split(" ");
				String artName = split[0];
				String cost = split[1];
				float price = Float.parseFloat(cost);
				Article article = new Article();
				article.pruductName = artName;
				article.price = price;
				pruductList.add(article);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
