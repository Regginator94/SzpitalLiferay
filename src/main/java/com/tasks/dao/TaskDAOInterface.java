package com.tasks.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.modul_pacjenta.model.PatientShortInfo;
import com.tasks.model.Task;

public interface TaskDAOInterface {
	public Task getTaskDetails(int id) throws DataAccessException;

	List<Task> getTaskDetails()
			throws DataAccessException;
	
	public void insertTaskDetails(Task task)
			throws DataAccessException;
}
