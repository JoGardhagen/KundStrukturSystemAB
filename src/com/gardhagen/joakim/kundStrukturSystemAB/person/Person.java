package com.gardhagen.joakim.kundStrukturSystemAB.person;

public class Person {
	protected int id;
	protected String forName;
	protected String lastName;
	protected String Adress;
	
	public Person(int id, String forName, String lastName, String adress) {
		super();
		this.id = id;
		this.forName = forName;
		this.lastName = lastName;
		this.Adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForName() {
		return forName;
	}
	public void setForName(String forName) {
		this.forName = forName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
}
