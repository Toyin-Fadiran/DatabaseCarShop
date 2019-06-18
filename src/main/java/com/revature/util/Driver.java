package com.revature.util;

import java.io.Serializable;
import java.util.List;

import com.revature.dao.CarDaoImpl;
import com.revature.dao.InventoryDAO;
import com.revature.dao.InventorySerializeDAO;
import com.revature.pojo.Car;
import com.revature.pojo.CarLot;
import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.services.UserService;
import com.revature.ui.Screen;
import com.revature.ui.WelcomeScreen;

public class Driver implements Serializable {

	public static InventoryDAO idao = new InventorySerializeDAO();
	
	static CarLot ca = CarLot.getInstance();
	
	public static void main(String[] args) {
		LoggingUtil.trace("start of the program");
		
		Inventory i = new Inventory();
		
//		public static Inventory getInstance() {
//			if (i == null)
//				i = new Inventory();
//			return i;
//		}
//		
		
		
//		
//		if(idao.loadFile() == null) {
//			
//			i = new Inventory();
//		} else {
//			
//			i = idao.loadFile();
//		}
	
		//update Carlot with database
//		
//		new Customer("Frodo", "Baggins", "ONEring", null, i);
//		new Customer("Gandalf", "Grey", "Staff", null, i);
//		new Customer("admin", "admin", "admin", null, i);
//		
//		CarDaoImpl cd = new CarDaoImpl();
//		
		
//		List<Car> dataBaseCars=
//		 cd.getAllCars();
		
		//ca.carLot.clear();
		
	//	for (Car c: dataBaseCars) {
		//	System.out.println(c);
	//	}
		
		//for (Car c: ca.currentCars) {
	//		System.out.println(c);
	//	}
		
		//ca.carLot.clear();
		
	//	for (int index = 0;index < cd.getAllCars().size(); index++) {
		//	ca.carLot.put(dataBaseCars.get(index).getAccountID(), dataBaseCars.get(index));
	//	}
		
		
		
		

		//  new Car("1", "2020Tesla", 5000.0, i);
		//new Car("2","1999FordTaurus", 500.0,i);
		
		//new WelcomeScreen(i);
	 new WelcomeScreen(i);

}

}