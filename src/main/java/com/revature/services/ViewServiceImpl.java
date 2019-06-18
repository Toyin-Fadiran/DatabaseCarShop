package com.revature.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.CarLot;

public class ViewServiceImpl implements Serializable {

	static CarLot c = CarLot.getInstance();
	//static CarSystem s = CarSystem.getInstance();
	private static ViewServiceImpl v = null;
	
	private ViewServiceImpl() {};
	
	public static ViewServiceImpl getInstance() {
		if (v == null)
			v = new ViewServiceImpl();
		return v;
	}
	
	public Object readResolve() {
		return getInstance();
	}
	
	
	
	public List<Car> getAllAccounts(){
		
		//Collection<Car> collection = c.carLot.values();
		Collection<Car> collection = c.carLot.values();
			
		ArrayList<Car> account = new ArrayList<>();
		
		for (Car a: collection)
		{
			account.add(a);
		}
		
		//List<Car> printCarLot = v.getAllAccounts();
		/*
		 * for (Car c: account) { System.out.println(c); }
		 */
		return account;
	}
	
	public Car retrieve (String s) {
		String accountID = s;
		if(c.carLot.containsKey(accountID)) {
			return c.carLot.get(accountID);
		}
		return null;
	}
	
	public void getCarsByOfferFlag() {
		
//		List<Car> ledger = getAllAccounts();
//		//List<Car> allAccounts = ledger.getAllAccounts();
//		ArrayList<Car> list2 = new ArrayList<>();
//		for (Car a: ledger){
//			if (a.isOfferFlag()){
//				list2.add(a);	
//			}
//		}
//		
//		for(Car a : list2) {
//			System.out.println(a);
//		}
		
	}

}
