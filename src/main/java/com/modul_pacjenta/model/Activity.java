package com.modul_pacjenta.model;

import java.util.Date;

public class Activity {
	private int patientId;
	private String activityType;
	private String additionalInfo;
	private Date activityDatetime;
	
	public Activity(int patientId, String activityType, String additionalInfo, Date activityDatetime) {
		this.setPatientId(patientId);
		this.setActivityType(activityType);
		this.setAdditionalInfo(additionalInfo);
		this.setActivityDatetime(activityDatetime);
	}
	
	public Activity() {
		
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Date getActivityDatetime() {
		return activityDatetime;
	}

	public void setActivityDatetime(Date activityDatetime) {
		this.activityDatetime = activityDatetime;
	}
	
	@Override
	public String toString() {
		return "Activity [patientId=" + patientId + ", activityType=" + activityType
				+ ", additionalInfo=" + additionalInfo + ", activityDatetime=" + activityDatetime
				+ "]";
	}
}
