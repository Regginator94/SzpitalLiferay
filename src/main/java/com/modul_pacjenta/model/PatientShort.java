package com.modul_pacjenta.model;

public class PatientShort {
	
	int patientId;
	String patientName;
	
	
	
	public PatientShort(int patientId, String patientName) {
		this.patientId = patientId;
		this.patientName = patientName;
	}

	

	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	@Override
	public String toString() {
		return this.patientId+", "+this.patientName;
	}
	
	
	

}
