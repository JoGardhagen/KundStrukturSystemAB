package application;

import javafx.scene.control.TextField;

public class UnitsIntHandler {
	public static int getIntFromTextField(TextField textField) {
		String text = textField.getText();
		return Integer.parseInt(text);
		
	}
	
}
