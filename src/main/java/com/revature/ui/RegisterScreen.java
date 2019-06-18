package com.revature.ui;

import java.io.Serializable;
import java.sql.Connection;

import com.revature.pojo.CarLot;
import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;
import com.revature.util.LoggingUtil;
import com.revature.util.TextValidator;
import com.revature.dao.*;
import com.revature.util.*;

public class RegisterScreen implements Screen {
	
	//static CarLot ca = CarLot.getInstance();
	//static Connection cf = ConnectionFactory.getConnection();
	
	//public static CustomerDao = new CustomerDaoImpl(

	Inventory I2;
	public RegisterScreen(Inventory i) {
		// TODO Auto-generated constructor stub
		I2= i;
		display(I2);
	}

	@Override
	public Screen display(Inventory i) {
		LoggingUtil.info("here is where I initially register customers");
		TextValidator t = TextValidator.getInstance();
	//	UserService s = UserService.getInstance();
	//	ViewServiceImpl uv = ViewServiceImpl.getInstance();
		while(true) {
			String tempFirst = t.askForString(1, 25, "Welcome to registration! Please enter your first name");
			String tempLast = t.askForString(1, 25, "Please enter your last name");
			String tempPass = t.askForString(1, 25, "Please enter your password.");
			Customer c = new Customer(tempFirst, tempLast, tempPass); 
		//	Customer c = new Customer(tempFirst, tempLast, tempPass);
//	//		Customer c = new Customer(tempFirst, tempLast, tempPass, null, i);
			CustomerDao newCustomer = new CustomerDaoImpl();
			newCustomer.createCustomer(c);
			


			return new WelcomeScreen(i);

		}
	}
	@Override
	public void printDisplay(Inventory i) {

		// TODO Auto-generated method stub

	}


}
