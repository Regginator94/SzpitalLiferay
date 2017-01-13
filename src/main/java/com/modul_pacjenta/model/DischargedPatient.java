package com.modul_pacjenta.model;

public class DischargedPatient {
	private PatientShortInfo patientShortInfo;
	private int patientShortInfoId;
	private String reason;
	private String comment;
	
	public DischargedPatient() {
		
	}
	
	public PatientShortInfo getPatientShortInfo() {
		return patientShortInfo;
	}
	
	public void setPatientShortInfo(PatientShortInfo patientShortInfo) {
		this.patientShortInfo = patientShortInfo;
	}
	
	public int getPatientShortInfoId() {
		return patientShortInfoId;
	}

	public void setPatientShortInfoId(int patientShortInfoId) {
		this.patientShortInfoId = patientShortInfoId;
	}	
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
