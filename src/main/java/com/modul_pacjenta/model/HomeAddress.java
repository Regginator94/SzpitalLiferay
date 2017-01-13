package com.modul_pacjenta.model;

public class HomeAddress {
	
	private String city;
	private String street;
	private String streetNumber; // String poniewa¿ mo¿e byæ np. 13/45 lub 45B
	private String code;
		
	public HomeAddress(String city, String street, String streetNumber, String code) {
		super();
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.code = code;
	}

	public HomeAddress() {
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
