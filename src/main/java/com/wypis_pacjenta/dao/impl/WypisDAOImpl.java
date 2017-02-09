package com.wypis_pacjenta.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;

@Service("WypisDAO")
@Scope("singleton")
public class WypisDAOImpl {
	
	
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
	//TO DO poprawic zapytanie oraz dostosowaï¿½ konstruktor do zapytania po utworzeniu tabeli w BD
	public PatientShortInfo getPatientShortInfo(int id) throws DataAccessException {
		PatientShortInfo patient = jdbcTemplate.queryForObject("SELECT id, name, second_name, surname, "
				+ "born_date, id_number, sex, phone_number, nationality, insurance_number FROM patient WHERE id=? AND discharged=false",
				new RowMapper<PatientShortInfo>(){
			public PatientShortInfo mapRow(ResultSet rs, int rowNumber)
					throws SQLException {
				return new PatientShortInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5),rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10));
			}

		}, new Object[] { id });	
		
		//ODKOMENTOWAÆ PO WPROWADZENIU DANYCH DO TABELI HOME_ADDESS\\\
		
//		patient.setHomeAddress(jdbcTemplate.queryForObject("SELECT city, street, number, code from home_address WHERE id=?",
//				new RowMapper<HomeAddress>(){
//			@Override
//			public HomeAddress mapRow(ResultSet rs, int rowNumber)
//					throws SQLException {
//				return new HomeAddress(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
//			}
//
//		}, new Object[] { id }));
		return patient;
	}
	
	public List<PatientShortInfo> getPatientShortInfo()
			throws DataAccessException {	
		return jdbcTemplate.query("SELECT id, name, second_name, surname, born_date, id_number, "
				+ "sex, phone_number, nationality, insurance_number FROM patient WHERE discharged=false",				
				new RowMapper<PatientShortInfo>(){

			public PatientShortInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PatientShortInfo patient = new PatientShortInfo(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getDate(5), rs.getLong(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getInt(10));
				System.out.println(patient);
				return patient ;
			}			
		});
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
	
	//obvious update na kolumnie bd
	public void updatePatientIfDischarged(int id) throws DataAccessException {
		jdbcTemplate.update(
		        "UPDATE patient SET discharged = TRUE where id = ?",id);
	}

	public void insertPatientDischargeDetails(DischargedPatient patient) throws DataAccessException {
		jdbcTemplate.update(
		        "INSERT INTO discharge_details (id, reason, comment, discharge_datetime) values (?, ?, ?, NOW())",
		        patient.getPatientShortInfoId(), patient.getReason(), patient.getComment());
	}

	public void updatePatientIfModified(PatientShortInfo patient, int id) throws DataAccessException {
		jdbcTemplate.update(
		        "UPDATE patient SET id=?, name=?, second_name=?, surname=?, born_date=?, id_number=?, "
		        + "sex=?, phone_number=?, nationality=?, insurance_number=? where id = ?",
				patient.getId(), patient.getName(), patient.getSecondName(), patient.getSurname(),
				patient.getBornDate(), patient.getIdNumber(), patient.getSex(), patient.getPhoneNumber(),
				patient.getNationality(), patient.getInsuranceNumber(), id);
		
	}

}
