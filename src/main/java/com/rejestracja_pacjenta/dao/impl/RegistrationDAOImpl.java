package com.rejestracja_pacjenta.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.modul_pacjenta.model.PatientShortInfo;

@Service("RegistrationDAO")
@Scope("singleton")
public class RegistrationDAOImpl {
	
	@Autowired()
	private ComboPooledDataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
	jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@PreDestroy
	public void cleanUp() {
		try {
			dataSource.close();
		} catch (Exception e) {
		}
	}
	
	// TO DO dopasowac zapytanie do nowych pol w klasie (+widok)
		public void insertPatientShortInfo(PatientShortInfo patient) throws DataAccessException {
			jdbcTemplate.update(
			        "INSERT INTO patient (id, name, second_name, surname, born_date, id_number, "
					+ "sex, phone_number, nationality, insurance_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					patient.getId(), patient.getName(), patient.getSecondName(), patient.getSurname(),
					patient.getBornDate(), patient.getIdNumber(), patient.getSex(), patient.getPhoneNumber(),
					patient.getNationality(), patient.getInsuranceNumber());
		}
		
		public void insertPatientRegistrationDetails(PatientShortInfo patient) throws DataAccessException {
			jdbcTemplate.update(
			        "INSERT INTO registration_details (id, registration_datetime) values (?, NOW())",
			        patient.getId());
		}
	
}
