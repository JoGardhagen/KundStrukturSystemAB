package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CommonCustomerControll implements PropertyChangeListener{
	//tillhör observer Mönster
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Common costumer "+evt.getSource());
		
	}

}
