package com.revature.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CarDao;
import com.revature.dao.CarDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.OfferDao;
import com.revature.dao.OfferDaoImpl;
import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.pojo.Offer;
import com.revature.pojo.User;
import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;
import com.revature.util.Driver;
import com.revature.util.LoggingUtil;
import com.revature.util.TextValidator;

public class DashboardScreen implements Screen {

	private static CarDao cDao = new CarDaoImpl();
	
	private static OfferDao od = new OfferDaoImpl();
	
	private static CustomerDao cd = new CustomerDaoImpl();
//	private static final Scanner SCAN = new Scanner(System.in);
Inventory I3;
	public DashboardScreen(Inventory i) {
		// TODO Auto-generated constructor stub
		I3 = i;
		printDisplay(I3);
	}

	@Override
	public Screen display(Inventory I3) {
		// TODO Auto-generated method stub
		TextValidator t = TextValidator.getInstance();
		ViewServiceImpl v = ViewServiceImpl.getInstance();
		int choice = t.askForInt(0, 4, "Please Select Choice", "View Cars on Lot", "Make Offer on Car");
		switch (choice){
		case 0:
			Driver.idao.saveFile(I3);
			System.exit(0);
		case 1:
			List<Car> printCarLot = v.getAllAccounts(); for (Car c: printCarLot) {
				System.out.println(c); } 

			//vs.viewCarLot(generic);
			return new LoginScreen(I3);
		case 2:

			return new RegisterScreen(I3);
		}	
		return null;
	}

	@Override
	public void printDisplay(Inventory I3) {
		LoggingUtil.info("here is where I address Customer issues");
		
		TextValidator t = TextValidator.getInstance();
	//	ViewServiceImpl v = ViewServiceImpl.getInstance();
	//	UserService s = UserService.getInstance();
		int choice = t.askForInt(0, 5, "Please Select a Car Choice", "View Cars on Lot",
				"Make Offer on Car", "View Cars I Own", "Logout");
		switch (choice){
		case 0:
			Driver.idao.saveFile(I3);
			System.exit(0);
		case 1:
			ArrayList<Car> printCustCarLot = cDao.getAllCars();
			for (Car c: printCustCarLot) {
				System.out.println(c);
			}
			break;
		case 2:
			String tempFirst = t.askForString(1, 25, "LOGIN: PLEASE First  NAME again: ");
			String tempPass = t.askForString(1, 25, "Please enter your password.");
			Integer custID =cd.getCustIDbyUsername(tempFirst);
			
			ArrayList<Car> printCustCarLot1 = cDao.getAllCars();
			for (Car c: printCustCarLot1) {
				System.out.println(c);
			}
			
			int carIDChoice = t.askForInt(0, 1000000, "Please choose car id to make offer: ");
			Car chosenCar =	cDao.getCarById(carIDChoice);
			chosenCar.setOfferFlag(true);
			cDao.preparedUpdateCar(chosenCar);
			
				//status pending
				double offerPrice = t.askForDouble(0, 1000000, "please make $$ offer on car: ");
				Integer pending = 1;
			Offer o = new Offer(custID, carIDChoice, pending, offerPrice);
			od.insertOffer(o);
			System.out.println("You have successfully placed offer on car!");
			
			break;
		case 3:
			String tempFirst1 = t.askForString(1, 25, "LOGIN: PLEASE First  NAME again: ");
			String tempPass1 = t.askForString(1, 25, "Please enter your password.");
			
			
			
			for (Car c: cd.viewCarsIOwn(tempFirst1))	{
				System.out.println(c);
			}
			

//			User temp2User = s.getByFirstName(temp2First);
//			Customer temp2Customer = (Customer) temp2User;
//			List<Car> tempCarList = temp2Customer.getPurchasedCars();
//			for (Car c: tempCarList ) {
//				System.out.println(c);
//				double remainingPayments = c.getPrice()/c.getMonthsNeeded();
//				System.out.printf("Cost of car: $%,.2f -- remaining payments:$%,.2f\n",
//						c.getPrice(), remainingPayments);
			break;	
			
			
			//List<Car> tempCarList = temp2Customer.getPurchasedCars();
			//for (Car c: tempCarList ) {
				
			//	break;
		//	}
		case 4:
			new LoginScreen(I3);
			break;
		}	
		new DashboardScreen(I3);

	}


}
