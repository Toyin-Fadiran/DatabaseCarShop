package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Connection conn;

	public EmployeeDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public EmployeeDaoImpl() {
		super();
		
	}

	@Override
	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByName(String username) {
		String sql = "select * from project_employee where firstname = '" +  username +  "'";
		Employee ret = null;
		Statement stmt;
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				ret = new Employee();
				ret.setEmployeeId(rs.getInt(1));
//				//ret.setFirstName(rs.getString("firstname"));
	//			ret.setFirstName(rs.getString("firstname"));
				ret.setFirstName(rs.getString(2));
				ret.setPassword(rs.getString(3));
				
			//	System.out.println((rs.getInt(1)));
//			//	ret.setFirstName(rs.getString("firstname"));
	//		//	ret.setFirstName(rs.getString("firstname"));
			//	System.out.println((rs.getString(2)));
			//	System.out.println((rs.getString(3)));
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preparedUpdateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
