package com.gardhagen.joakim.kundStrukturSystemAB.products;

import javafx.scene.control.TextField;
// hanler for Prase Int from textfield 
public class UnitsIntHandler {
	// metoden anv�nds f�r textf�lt objektet f�r konvertering fr�n string till int
	public static int getIntFromTextField(TextField textField) {
		String text = textField.getText();
		return Integer.parseInt(text);
		
	}
	
}
