package com.revature.ui;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CarDao;
import com.revature.dao.CarDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.OfferDao;
import com.revature.dao.OfferDaoImpl;
import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.pojo.Offer;
import com.revature.pojo.User;
import com.revature.pojo.UserInventory;
import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;
import com.revature.util.ConnectionFactory;
import com.revature.util.Driver;
import com.revature.util.LoggingUtil;
import com.revature.util.TextValidator;

public class EmployeeScreen implements Screen{
	
	private static CarDao carDao = new CarDaoImpl();
	private static OfferDao od = new OfferDaoImpl();
	private static Connection conn = ConnectionFactory.getConnection();
	
	Inventory I3;
	public EmployeeScreen(Inventory i) {
		I3 = i;
		printDisplay(I3);
	}

//
	@Override
	public Screen display(Inventory i) {
		return null;
//		TextValidator t = TextValidator.getInstance();
//		ViewServiceImpl v = ViewServiceImpl.getInstance();
//		int choice = t.askForInt(0, 4, "Employee Functions: ", "View CarLot", "Register");
//		switch (choice) {
//		case 0:
//			Driver.idao.saveFile(i);
//			System.exit(0);
//		case 1:
//			// System.out.println(v.getAllAccounts());
//
//			List<Car> printCarLot = v.getAllAccounts();
//			for (Car c : printCarLot) {
//				System.out.println(c);
//			}
//			// break;
//
//			// return new EmployeeScreen();
//			// printDisplay(choice);
//			return display(i);
//		case 2:
//			return new RegisterScreen(i);
//		
//		return new EmployeeScreen(i);
//	}
	}


	@Override
	public void printDisplay(Inventory i) {
		LoggingUtil.info("here is where I address Employee concerns");
		TextValidator t = TextValidator.getInstance();
	//	ViewServiceImpl v = ViewServiceImpl.getInstance();
	//	UserService uv = UserService.getInstance();
	//	UserInventory ui = UserInventory.getInstance();
		//SystemService sys = SystemService.getInstance();
		int choice = t.askForInt(0, 6, "Employee Functions: ", "View CarLot" ,"Add Car to Lot", 
				"Remove Car from Lot", "Accept or Reject Offer on car", "view customer payments ", "Logout");
		switch (choice){
		case 0:
		CustomerDaoImpl cd = new CustomerDaoImpl();
		
		for (Customer c: cd.getAllCustomers()){
			System.out.println(c);
			
		}
			//change this BACK!!!!!
			//System.exit(0);
		case 1:
			ArrayList<Car> printCarLot = carDao.getAllCars();
			for (Car c: printCarLot) {
				System.out.println(c);
				
			}			
			break;
		case 2:
			String tempName = t.askForString(1, 25, "Car Year and name: ");
			Double tempPrice = t.askForDouble(0, 100000., "Price of Car: ");
		Car c = new Car(null, tempName, tempPrice, true, false);
		carDao.createCar(c);
		System.out.println(c.getName() + "successfully added to lot");
		LoggingUtil.info(c.toString());
		//new Car( int customerID, String name, Double price, boolean forSale, boolean offerFlag );
			break;
		case 3:
			ArrayList<Car> removeFromCarLot = carDao.getAllCars();
			for (Car ca: removeFromCarLot) {
				System.out.println(ca);
			}
			
//			String removedCar= t.askForString(0, 25, "What Car will you remove? use car_id: ");
			int removedCar= t.askForInt(0, 100000, "What Car will you remove? use car_id: ");
			Car rc = carDao.getCarById(removedCar);
			rc.setForSale(false);
			carDao.deleteCar(rc);
			//carDao.deleteCar(c);
			break;
		case 4:
			ArrayList<Car> bidCars = 	carDao.getAllBiddedCars();
			for (Car ca: bidCars) {
				System.out.println(ca);
			}			
			int car2view = t.askForInt(0, 100000, "What Car will you view offers on? use car_id: ");
			
			for(Offer li: od.getOffersbyCarID(car2view)) {
				System.out.println(li);
			}
			
			int offerChosen = t.askForInt(0, 100000, "What Offer do you accept? use offer_id: ");
		int customerIDofWinner=	od.getCustomerIDbyofferID(offerChosen);
		
		//we have car2view, offerChosen, and customerIDofWinner
		
		String sql = "{call accept_offer_proc(?,?)}";
		try {//Connection conn = DriverManager.getConnection(url, username, password)){
			
			//conn.setAutoCommit(false);
			
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, customerIDofWinner);
			call.setInt(2, car2view);
			call.executeQuery();
			//rsInit.next();
			//ResultSet curs = (ResultSet) rsInit.getObject(1);
			//while (curs.next()) {
			//	System.out.println("Name: " + curs.getString(1));
			//	System.out.println("Unit Price: " + curs.getDouble(2));
			
			
		} catch (SQLException e) {
			LoggingUtil.error("Failed to connect....or something");
			e.printStackTrace();
		}
			
		//	v.getCarsByOfferFlag();
		//	String tempOfferString  = t.askForString(0, 25, "What car offers would you like to view? Choose Car ID");
		//	Car tempCar = v.retrieve(tempOfferString);
		//	tempCar.getMadeOffers().forEach( (key,value)->
			//{
			//	System.out.println("Key =" + key);
			//	System.out.println("Value=" + value);
			//	System.out.println();
			//});
			//	String acceptedOffer =t.askForString(0, 25, "Which offer do you accept?");
			//	User tempUser= uv.getByFirstName(acceptedOffer);
		//		Customer tempCustomer = (Customer) tempUser;
			//	Car purchasedCar = new Car(tempCar.getAccountID(), tempCar.getName(), 
			//			tempCar.getMadeOffers().get(acceptedOffer), i);
			//	tempCustomer.getPurchasedCars().add(purchasedCar);
				
				//tempCustomer.setOwnCar(true);
	//			//tempUser.ownCar = true;
				
//				tempCustomer.setOwnCar(true);
				//System.out.println(tempCustomer.getOwnCar());
				
			//	System.out.println("how many months needed to pay purchase of " 
			//	+ purchasedCar.getName() + "?");
				
//				int month = t.askForInt(0, 4, "Please choose month #", "12", "24", "36");
//				switch (month){
//					case 0:
//						break;
//					case 1:
//						month = 12;
//						purchasedCar.setMonthsNeeded((double)month);
//						break;
//					case 2:
//						month = 24;
//						purchasedCar.setMonthsNeeded((double)month);
//						break;
//					case 3:
//						month = 36;
//						purchasedCar.setMonthsNeeded((double)month);
//						break;
//				}	
				
				//List<Car> tempList = tempCustomer.getPurchasedCars();
			//	tempList.add(purchasedCar);
				//tempCustomer.setPurchasedCars(tempList);
//				
//				//uv.AddCarToCustomer(purchasedCar, tempCustomer);
//				//tempCustomer.getPurchasedCars().add(purchasedCar);
//				//((Customer) uv.getByFirstName(acceptedOffer)).getPunrchasedCars().add(purchasedCar);
//				tempCar.getMadeOffers().forEach( (key,value)->
//				{
//					((Customer) uv.getByFirstName(key)).setPendingOffer(false);
//				});
//			
//				uv.removeCarFromLot(tempCar.getAccountID());
//				
//				//System.out.println(purchasedCar);
//				
//				//.getPurchasedCars().add(purchasedCar);t
//				
//				
				
			//	System.out.println(tempCustomer.getPurchasedCars().size());
			
			break;
		case 5:

//			List<User> tempList = new ArrayList<>(); 
//			for (User c: ui.users) { 
//				if(c.ownCar) { 
//					tempList.add(c); } 
//				}
//
//			

	/*		
			//List<Customer> temp2List = new ArrayList<>();
			//for (User c:  ui.users) {
				if(  ((Customer) c).ownCar ) {
					
					ListIterator<Customer> it = (Customer) c).purchasedCar.
				System.out.println(  (Customer) c   );
				}
			*/
				/*
				 * double remainingPayments = c.getPrice()/c.getMonthsNeeded();
				 * System.out.printf("Cost of car: $%,.2f -- remaining payments:$%,.2f\n",
				 * c.getPrice(), remainingPayments);
				 */
		
		
			break;
		case 6: 
			new WelcomeScreen(i);
			//uv.getByFirstName(tempOfferString);
		}
		new EmployeeScreen(i);


}
}


	
