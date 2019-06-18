package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;

public interface CustomerDao {

	public void createCustomer(Customer c);
	
	public void updateCustomer(Customer c);
	
	public void deleteCustomer(Customer c);
	
	public Customer getCustomerById(Integer id);
	
	public Customer getUserByUsername(String username);
	
	public int getCustIDbyUsername(String username);
	
	public List getAllCustomers();

	void preparedUpdateUser(Customer c);
	
	public ArrayList<Car> viewCarsIOwn(String username);
	
	

}
