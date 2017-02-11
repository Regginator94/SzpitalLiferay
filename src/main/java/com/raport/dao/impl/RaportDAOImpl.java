package com.raport.dao.impl;

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
import com.modul_pacjenta.model.Activity;
import com.modul_pacjenta.model.PatientShortInfo;

@Service("RaportDAO")
@Scope("singleton")
public class RaportDAOImpl {
	
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
				return patient ;
			}			
		});
	}
	
	
//	SELECT concat(patient.name, " ", patient.surname) as patient, activity_type, additional_info, activity_datetime FROM 
//	`activities` join patient on patient_id = patient.id 
//	where activity_datetime > NOW() - INTERVAL 8 HOUR order by activity_datetime asc
	
	public Activity patientActivity(int patientId)throws DataAccessException{
		Activity patient = jdbcTemplate.queryForObject("SELECT concat(patient.name,\"\" , patient.surname) as patient, activity_type, additional_info, "
				+ "activity_datetime FROM `activities` join patient on "
				+ "patient_id = patient.id where id = ? AND activity_datetime > NOW() - INTERVAL 8 HOUR order by activity_datetime asc",
				new RowMapper<Activity>(){
			public Activity mapRow(ResultSet rs, int rowNumber)
					throws SQLException {
				return  new Activity(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getDate(4));
			}

		}, new Object[] { patientId });	
		
		return patient;
	}
}
