package com.tasks.model;

import java.sql.Date;

public class Task {
	private int id;
	private String title;
	private String description;
	private int priority; // 3 - low 2 - medium 1 - high
	private int status;  // 3 - done 2 - pending 1 - not done
	private Date date; 
	
	
	public Task(int id, String title, String description, int priority,
			int status, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.date = date;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
