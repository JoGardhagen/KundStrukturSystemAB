package com.gardhagen.joakim.kundStrukturSystemAB.person.seller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CommonCustomerControll implements PropertyChangeListener{
	//tillh�r observer M�nster
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Common costumer "+evt.getSource());
		
	}

}
