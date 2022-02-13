package com.gardhagen.joakim.kundStrukturSystemAB.export;

import java.io.FileWriter;
import java.io.PrintWriter;
// Singelton M�nster
public class Export {
	private static Export export = null;
	private final String exportFile = "export_CRM-Demo.txt";// den h�r filen skapas n�r man klickar p� exportData Knappen
	private PrintWriter writer;
	
	private Export() {
		try {
			FileWriter fw = new FileWriter(exportFile);
			writer = new PrintWriter(fw ,true);
		} catch (Exception e) {
		System.out.println("somthing went wrong");	
		}
		
	}
	public void printExport(String string) {
		writer.println(string);// skriver str�ng till Fil
	}
	public static Export getInstance() {
		if(export ==null)
			export = new Export();
		return export;
	}
	
}
