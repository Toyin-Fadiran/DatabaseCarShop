package com.revature.services;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.dao.CarDaoImpl;
import com.revature.pojo.Car;
import com.revature.pojo.CarLot;
import com.revature.pojo.Inventory;
import com.revature.pojo.User;
import com.revature.pojo.UserInventory;
import com.revature.util.ConnectionFactory;

public class UserService implements Serializable {

	static UserInventory c = UserInventory.getInstance();
	static CarLot ca = CarLot.getInstance();
	private static Connection conn = ConnectionFactory.getConnection();
//  private Car car;
//	private static Scanner SCAN = new Scanner(System.in);
	// final
	private static UserService s = null;
	private static CarDaoImpl carDao = new CarDaoImpl();
	//int  newID = 0;

	private UserService() {
	};

	public static UserService getInstance() {
		if (s == null)
			s = new UserService();
		return s;
	}

	public Object readResolve() {
		return getInstance();
	}

	public User getByFirstName(String s) {
		for (User u : c.users) {
			if (u.getFirstName().equalsIgnoreCase(s))
				return u;
		}
		System.out.println("USER NOT FOUND");
		return null;
	}

	public String getNextCarID() {
		return ((ca.carLot.size()) + 1 + "");

	}

//	public Car createCar(Inventory i) {
//		System.out.println("Please input car year and name: ");
//		Scanner keyboard = new Scanner(System.in);
//		
//		String input1 = keyboard.nextLine();
//		
//		System.out.println("Please enter MSRP: ");
//
//		Double input2 = keyboard.nextDouble();
//		
//		String sql = "select * from project_car";
//		
//		Car c = new Car(input1, input2, true);
//
//			
//			
//			
//			Statement stmt = conn.createStatement();
//			//conn.setAutoCommit(false);  //needs to be done to run transactions
//			//Savepoint sp = conn.setSavepoint("Before creating a new car");
//			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//			ResultSet rs = stmt.getGeneratedKeys();
//			rs.nex
//			if (rs.next()) {
//				newID = rs.getInt(1);
//				return new Car(newID, null, input1, input2, true, i);
//			
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//		
//		}
//	}
//		


	//return( new Car(this.getNextCarID(), input1, input2));	
		
	//return ( new Car(this.getNextCarID(), input1, input2, i));
		//new Car(carID, customerID, name, price, forSale)

//	public void AddCarToLot(Inventory i) {
//		Car c = createCar(i);
//		ca.carLot.put(c.getAccountID(), c);
//	}

	/*
	 * public void AddCarToCustomer(Car car, Customer customer) { List<Car> tempList
	 * = getPurchasedCars();
	 * 
	 * customer.getPurchasedCars().add(car); }
	 */

	public boolean removeCarFromLot(String s, Car c) {
		String accountID = s;
		if (ca.carLot.containsKey(accountID)) {
			System.out.println(c.getName() + "successfully removed from carLot");
			ca.carLot.remove(accountID, c);
		}

		return false;

	}

	public Car removeCarFromLot(String s) {
		String accountID = s;
		if (ca.carLot.containsKey(accountID)) {
			System.out.println((ca.carLot.get(accountID)) + "successfully removed from carlot");
			return (ca.carLot.remove(accountID));
		}
		return null;
	}

}


