package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarLot implements Serializable{

	//private static final CarLot instance = new CarLot();
		private static CarLot cl = null;

		private CarLot() {
		}

		public static Map<String, Car> carLot = new HashMap<String, Car>();
		
		public static ArrayList<Car> currentCars = new ArrayList<>();
		
		public static Map<Integer, Car> dataCars = new HashMap<>();
		

	//private static final Scanner SCAN = new Scanner(System.in);

		//private Employee employee;

		// Scanner keyboard = new Scanner(System.in);

		public static CarLot getInstance() {
			if (cl == null)
				cl = new CarLot();
			return cl;
		}
		public Object readResolve() {
			return getInstance();
		}
		
		/*
		 * public static CarLot getInstance() { return instance; }
		 */

		/*
		 * public boolean store(Car c) {
		 * 
		 * if (carLot.containsKey(c.getAccountID())) { return false; } accounts.put(c.)
		 * }
		 */

		public String getNextCarID() {
			return ((carLot.size()) + 1 + "");

		}

		public Car retrieve(String s) {
			String accountID = s;
			if (carLot.containsKey(accountID)) {
				return carLot.get(accountID);
			}
			return null;
		}

		public Car createCar() {
			System.out.println("Please input car year and name: ");

			// String input1 = SCAN.nextLine();

			System.out.println("Please enter MSRP: ");

//		Double input2 = SCAN.nextDouble();

	//return( new Car(this.getNextCarID(), input1, input2));	
			return null;
		}

		public void AddCarToLot() {
			Car c = createCar();
	//		carLot.put(c.getAccountID(), c);
		}

		public boolean removeCarFromLot(String s, Car c) {
			String accountID = s;
			if (carLot.containsKey(accountID)) {
				System.out.println(c.getName() + "successfully removed from carLot");
				carLot.remove(accountID, c);
			}

			return false;

		}

		public Car removeCarFromLot(String s) {
			String accountID = s;
			if (carLot.containsKey(accountID)) {
				System.out.println((carLot.get(accountID)) + "successfully removed from carlot");
				return (carLot.remove(accountID));
			}
			return null;
		}

		/*
		 * public static Map<String, Car> getCarlot() { return carLot; }
		 */

		
		  public List<Car> getAllAccounts(){
		 
		  Collection<Car> collection = carLot.values();
		  
		  ArrayList<Car> account = new ArrayList<>();
		  
		 for (Car a: collection) { account.add(a); } return account; }
		 


}
