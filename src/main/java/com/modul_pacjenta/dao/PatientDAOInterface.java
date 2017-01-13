package com.modul_pacjenta.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;

public interface PatientDAOInterface {
	
	public PatientShortInfo getPatientShortInfo(int id) throws DataAccessException;

	List<PatientShortInfo> getPatientShortInfo()
			throws DataAccessException;
	
	public void insertPatientShortInfo(PatientShortInfo patient)
			throws DataAccessException;
	
	public void insertPatientRegistrationDetails(PatientShortInfo patient)
			throws DataAccessException;
	
	public void updatePatientIfDischarged(int id)
			throws DataAccessException;
	
	public void insertPatientDischargeDetails(DischargedPatient patient)
			throws DataAccessException;
}
