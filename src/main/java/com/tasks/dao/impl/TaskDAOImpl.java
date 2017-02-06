package com.tasks.dao.impl;

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
import com.tasks.dao.TaskDAOInterface;
import com.tasks.model.Task;


@Service("TaskDAO")
@Scope("singleton")
public class TaskDAOImpl implements TaskDAOInterface {

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
	
	public Task getTaskDetails(int id) throws DataAccessException {
		Task task = jdbcTemplate.queryForObject("SELECT id, title, description, priority, "
				+ "status, date FROM tasks WHERE id=?",
				new RowMapper<Task>() {
					
					public Task mapRow(ResultSet rs, int rowNumber)
							throws SQLException {
						return new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6));
					}
				}, new Object[] { id });
		return task;
	}

	
	public List<Task> getTaskDetails() throws DataAccessException {	
			return jdbcTemplate.query("SELECT id, title, description, priority, "
					+ "status, date FROM tasks",				
					new RowMapper<Task>(){

				public Task mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Task task = new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6));
					System.out.println(task);
					return task ;
				}			
			});
	}

	public void insertTaskDetails(Task task) throws DataAccessException {
		jdbcTemplate.update(
		        "INSERT INTO task (id, title, description, priority, "
				+ "status, date) values (?, ?, ?, ?, ?, ?)",
				task.getId(), task.getTitle(), task.getDescription(), task.getPriority(),
				task.getStatus(), task.getDate());
	}

}
