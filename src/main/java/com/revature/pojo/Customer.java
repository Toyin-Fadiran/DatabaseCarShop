package com.revature.pojo;




public class Customer extends User {

	
	private Integer customerID;
	private String firstName;
	private String lastName;
	private String password;
	
	public Customer( Integer customerID, String firstName, String lastName, String password) {
		super(firstName, lastName, password, null);
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public Customer(String firstName, String lastName, String password) {
		super(firstName, lastName, password, null);
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	








}
