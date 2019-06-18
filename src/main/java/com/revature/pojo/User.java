package com.revature.pojo;

import java.io.Serializable;

public class User implements Serializable {

	protected String firstName;
	protected String lastName;
	protected String password;
	protected Car car;
	public Boolean ownCar =false;
	
	
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	private String userType;
	
	public User(String first, String last, String pass, Car car) {
		this.firstName = first;
		this.lastName = last;
		this.password = pass;
		this.car = car;
	}

	public User(int int1, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

}
