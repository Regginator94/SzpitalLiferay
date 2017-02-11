package com.modul_pacjenta.model;

import java.util.Date;

public class PatientShortInfo extends Person{
	
	private int insuranceNumber;
	private String healthStatus;
	private String disease;
	private String medicines;
	private String allergies;
		
	public PatientShortInfo(int id, String name, String secondName,
			String surname, Date bornDate, long idNumber, String sex,
			String phoneNumber, String nationality, int insuranceNumber, String homeAddress) {
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
		this.insuranceNumber = insuranceNumber;
		this.homeAddress = homeAddress;
	}

	public PatientShortInfo(int id, String name, String secondName, String surname,
			Date bornDate, long idNumber, String sex, String phoneNumber,
			String nationality, int insuranceNumber, String homeAddress,
			String healthStatus, String disease, String medicines, String allergies) {
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.surname = surname;
		this.bornDate = bornDate;
		this.idNumber = idNumber;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.insuranceNumber = insuranceNumber;
		this.homeAddress = homeAddress;
		this.healthStatus = healthStatus;
		this.disease = disease;
		this.medicines = medicines;
		this.allergies = allergies;
	}
	
	public PatientShortInfo() {
		// TODO Auto-generated constructor stub
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

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public int getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(int insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "PatientShortInfo [id=" + id + ", name=" + name
				+ ", secondName=" + secondName + ", surname=" + surname
				+ ", bornDate=" + bornDate + ", idNumber=" + idNumber
				+ ", sex=" + sex + ", phoneNumber=" + phoneNumber
				+ ", nationality=" + nationality + ", homeAddress="
				+ homeAddress + ", insuranceNumber=" + insuranceNumber + "]";
	}
}