package com.gardhagen.joakim.kundStrukturSystemAB.timeStamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
	LocalDateTime dateTime = LocalDateTime.now();
	DateTimeFormatter dateTimeFormated = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	public TimeStamp() {
		
	}
	@Override
	public String toString() {
		return " " + dateTime.format(dateTimeFormated);
	}
	
}
