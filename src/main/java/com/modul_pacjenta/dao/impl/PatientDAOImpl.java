package com.modul_pacjenta.dao.impl;

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
import com.modul_pacjenta.dao.PatientDAOInterface;
import com.modul_pacjenta.model.Activity;
import com.modul_pacjenta.model.DischargedPatient;
import com.modul_pacjenta.model.PatientShortInfo;

@Service("PatientDAO")
@Scope("singleton")
public class PatientDAOImpl implements PatientDAOInterface{
		
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
				+ "born_date, id_number, sex, phone_number, nationality, insurance_number, home_address "
				+ "FROM patient WHERE id=? AND discharged=false",
				new RowMapper<PatientShortInfo>(){
			public PatientShortInfo mapRow(ResultSet rs, int rowNumber)
					throws SQLException {
				return new PatientShortInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5),rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10), rs.getString(11));
			}

		}, new Object[] { id });	
		
		//ODKOMENTOWAÆ PO WPROWADZENIU DANYCH DO TABELI HOME_ADDESS\\\
		
//		patient.setString(jdbcTemplate.queryForObject("SELECT city, street, number, code from home_address WHERE id=?",
//				new RowMapper<String>(){
//			@Override
//			public String mapRow(ResultSet rs, int rowNumber)
//					throws SQLException {
//				return new String(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
//			}
//
//		}, new Object[] { id }));
		return patient;
	}
	
	public List<PatientShortInfo> getPatientShortInfo()
			throws DataAccessException {	
		return jdbcTemplate.query("SELECT id, name, second_name, surname, born_date, id_number, "
				+ "sex, phone_number, nationality, insurance_number, home_address FROM patient WHERE discharged=false",				
				new RowMapper<PatientShortInfo>(){

			public PatientShortInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PatientShortInfo patient = new PatientShortInfo(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getDate(5), rs.getLong(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11));
				System.out.println(patient);
				return patient ;
			}			
		});
	}
	
	// TO DO dopasowac zapytanie do nowych pol w klasie (+widok)
	public void insertPatientShortInfo(PatientShortInfo patient) throws DataAccessException {
		jdbcTemplate.update(
		        "INSERT INTO patient (id, name, second_name, surname, born_date, id_number, "
				+ "sex, phone_number, nationality, insurance_number, home_address, health_status, "
				+ "disease, medicines, allergies) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				patient.getId(), patient.getName(), patient.getSecondName(), patient.getSurname(),
				patient.getBornDate(), patient.getIdNumber(), patient.getSex(), patient.getPhoneNumber(),
				patient.getNationality(), patient.getInsuranceNumber(), patient.getHomeAddress(),
				patient.getHealthStatus(), patient.getDisease(), patient.getMedicines(), patient.getAllergies());
	}
	
	public void insertPatientRegistrationDetails(PatientShortInfo patient) throws DataAccessException {
		jdbcTemplate.update(
		        "INSERT INTO registration_details (id, registration_datetime) values (?, NOW())",
		        patient.getId());
		jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, activity_datetime) values (?, ?, NOW())",
		        patient.getId(), "Rejestracja pacjenta");
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
		jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, additional_info, activity_datetime) values (?, ?, ?, NOW())",
		        patient.getPatientShortInfoId(), "Wypis pacjenta", patient.getComment());
	}

	public void updatePatientIfModified(PatientShortInfo patient, int id) throws DataAccessException {
		jdbcTemplate.update(
		        "UPDATE patient SET id=?, name=?, second_name=?, surname=?, born_date=?, id_number=?, "
		        + "sex=?, phone_number=?, nationality=?, insurance_number=?, home_address=? where id = ?",
				patient.getId(), patient.getName(), patient.getSecondName(), patient.getSurname(),
				patient.getBornDate(), patient.getIdNumber(), patient.getSex(), patient.getPhoneNumber(),
				patient.getNationality(), patient.getInsuranceNumber(), patient.getHomeAddress(), id);
		jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, activity_datetime) values (?, ?, NOW())",
		        patient.getId(), "Modyfikacja danych osobowych pacjenta");
	}

	public PatientShortInfo getPatientFullInfo(int id)
			throws DataAccessException {
		PatientShortInfo patient = jdbcTemplate.queryForObject("SELECT id, name, second_name, surname, "
				+ "born_date, id_number, sex, phone_number, nationality, insurance_number, home_address, "
				+ "health_status, disease, medicines, allergies FROM patient WHERE id=? AND discharged=false",
				new RowMapper<PatientShortInfo>(){
			public PatientShortInfo mapRow(ResultSet rs, int rowNumber)
					throws SQLException {
				return new PatientShortInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5),rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15));
			}

		}, new Object[] { id });	
		
		return patient;
	}

	public void updatePatientCard(PatientShortInfo patient)
			throws DataAccessException {
		if (patient.getAllergies()!=null) {
			jdbcTemplate.update(
			        "UPDATE patient SET allergies = IF(allergies is null, ?, concat(allergies,?)) where id = ?",
			        patient.getAllergies(), ", " + patient.getAllergies(), patient.getId());
			jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, additional_info, activity_datetime) values (?, ?, ?, NOW())",
		        patient.getId(), "Dodanie nowych alergii", patient.getAllergies());
		}
		if (patient.getMedicines()!=null) {
			jdbcTemplate.update(
			        "UPDATE patient SET medicines = IF(medicines is null, ?, concat(medicines,?)) where id = ?",
			        patient.getMedicines(), ", " + patient.getMedicines(), patient.getId());
			jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, additional_info, activity_datetime) values (?, ?, ?, NOW())",
		        patient.getId(), "Dodanie nowych lekow", patient.getMedicines());
		}
		if (patient.getHealthStatus()!=null) {
			jdbcTemplate.update(
			        "UPDATE patient SET health_status = ? where id = ?",
			        patient.getHealthStatus(),  patient.getId());
			jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, additional_info, activity_datetime) values (?, ?, ?, NOW())",
		        patient.getId(), "Zmiana stanu pacjenta", patient.getHealthStatus());
		}
	}

	public List<Activity> getActivity(int id) throws DataAccessException {
		return jdbcTemplate.query("SELECT patient_id, activity_type, additional_info, activity_datetime FROM activities WHERE patient_id=? ORDER BY activity_datetime desc",				
				new RowMapper<Activity>(){

			public Activity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Activity activity = new Activity(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getDate(4));
				System.out.println(activity);
				return activity;
			}			
		}, new Object[] { id });
	}

	public void insertActivity(Activity activity) throws DataAccessException {
		jdbcTemplate.update(
		        "INSERT INTO activities (patient_id, activity_type, additional_info, activity_datetime) "
				+ "values (?, ?, ?, NOW())",
				activity.getPatientId(), activity.getActivityType(), activity.getAdditionalInfo());
	}
	
}
