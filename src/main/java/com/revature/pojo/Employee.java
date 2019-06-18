package com.revature.pojo;

public class Employee {

	
	private int employeeId;
	private String firstName;
	private String password;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Employee(String firstName, String password) {
		super();
		//this.employeeId = employeeId;
		this.firstName = firstName;
		this.password = password;
	}
	
	public Employee(int employeeId, String firstName, String password) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.password = password;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
