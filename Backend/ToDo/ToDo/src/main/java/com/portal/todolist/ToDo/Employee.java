package com.portal.todolist.ToDo;

import java.util.Date;

public class Employee {
	
	private String name;
	private Date joiningDate;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", joiningDate=" + joiningDate + "]";
	}
	public Employee(String name, Date joiningDate) {
		super();
		this.name = name;
		this.joiningDate = joiningDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

}
