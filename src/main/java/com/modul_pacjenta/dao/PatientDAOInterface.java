package com.modul_pacjenta.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.modul_pacjenta.model.Activity;
import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;

public interface PatientDAOInterface {
	
	public PatientShortInfo getPatientShortInfo(int id) throws DataAccessException;

	List<PatientShortInfo> getPatientShortInfo()
			throws DataAccessException;
	
	public PatientShortInfo getPatientFullInfo(int id) 
			throws DataAccessException;

	public void insertPatientShortInfo(PatientShortInfo patient)
			throws DataAccessException;
	
	public void insertPatientRegistrationDetails(PatientShortInfo patient)
			throws DataAccessException;
	
	public void updatePatientIfDischarged(int id)
			throws DataAccessException;
	
	public void insertPatientDischargeDetails(DischargedPatient patient)
			throws DataAccessException;
	
	public void updatePatientIfModified(PatientShortInfo patient, int id)
			throws DataAccessException;
	
	public void updatePatientCard(PatientShortInfo patient)
			throws DataAccessException;

	List<Activity> getActivity(int id)
			throws DataAccessException;
	
	public void insertActivity(Activity activity)
			throws DataAccessException;

}
