package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;


public class CustomerDaoImpl implements CustomerDao {

	private static Connection conn = ConnectionFactory.getConnection();
	
	private static CarDao cd = new CarDaoImpl();

	@Override
	public void createCustomer(Customer c) {
//		try {//Connection conn =DriverManager.getConnection(url, user, password);
//			System.out.println("made into createCustomer");
//			conn = ConnectionFactory.getConnection();
//			Statement stmt = conn.createStatement();
//			conn.setAutoCommit(false);
//			Savepoint sp = conn.setSavepoint("Before Create");
//			String query = "insert into project_customer values ( DEFAULT, '" + c.getFirstName() + "' , '" + c.getLastName() + "' , '" + c.getPassword() + "'  )";
//			stmt.executeUpdate(query);
//			//LoggingUtil.info(msg);
//			conn.commit();
//			conn.setAutoCommit(true);
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		
		
		
		
		
		try {
			conn.setAutoCommit(false);
			String query = "insert into project_customer(firstname, lastname, pass_word) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getFirstName());
			pstmt.setString(2, c.getLastName());
			pstmt.setString(3, c.getPassword());
			Savepoint sp = conn.setSavepoint("Before Create");
			pstmt.execute();
		//	boolean check = pstmt.execute();
		//	if (check) {
			//	conn.rollback(sp);
			//	LoggingUtil.error("Customer was not added. Rolling back");
			//}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating a customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(Customer c) {
		try {
			
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");
			String query = "update user_table set password = '" + c.getPassword() + "' where username = '" + c.getFirstName() + "'";
			int numberOfRows = stmt.executeUpdate(query);
			
			if (numberOfRows > 1) {
				conn.rollback(sp);
				System.out.println("Too many rows affected");
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
List<Customer> custList = new ArrayList<Customer>();
		
		String sql = "select * from project_customer";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				custList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return custList;
	}

	@Override
	public void preparedUpdateUser(Customer c) {
		// TODO Auto-generated method stub
		
	}
	

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Car> viewCarsIOwn(String userName) {
		ArrayList<Car> outCars = new ArrayList<Car>();
	//	Car ret = null;
		//String sql = "select customerid from project_customer where  =" + id;
		
		String sql2 = "select carid from project_car where customerid in (select customerid from project_customer where firstname = '" + userName + "')";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				//=rs.getInt(1)
		outCars.add(   cd.getCarById(rs.getInt(1))           )	;	
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outCars;
	}

	@Override
	public int getCustIDbyUsername(String username) {
		String sql = "select customerid from project_customer where firstname ='" + username + "'";
		int custID =0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				custID  = rs.getInt("customerid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custID;
	}
	}



