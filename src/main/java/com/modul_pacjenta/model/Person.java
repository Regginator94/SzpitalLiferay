package com.modul_pacjenta.model;

import java.util.Date;

public class Person {
	protected int id;
	protected String name;
	protected String secondName;
	protected String surname;
	protected Date bornDate;
	protected long idNumber;
	protected String sex;
	protected String phoneNumber;
	protected String nationality;
	protected HomeAddress homeAddress;
	
	public Person(){
		
	}
	public Person(int id, String name, String secondName, String surname,
			Date bornDate, long idNumber, String sex, String phoneNumber,
			String nationality, HomeAddress homeAddress) {
		super();
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.surname = surname;
		this.bornDate = bornDate;
		this.idNumber = idNumber;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.homeAddress = homeAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public HomeAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}

}