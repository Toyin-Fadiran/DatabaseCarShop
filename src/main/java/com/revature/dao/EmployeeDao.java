package com.revature.dao;

import java.util.List;


import com.revature.pojo.Employee;

public interface EmployeeDao {

	
	public void createEmployee(Employee e);
	
	public void updateEmployee(Employee e);
	
	public void deleteEmployee(Employee e);
	
	public Employee getEmployeeById(Integer id);
	
	public Employee getEmployeeByName(String username);
	
	public List<Employee> getAllEmployees();

	void preparedUpdateEmployee(Employee e);
}
