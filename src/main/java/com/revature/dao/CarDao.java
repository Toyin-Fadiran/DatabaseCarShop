package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;



public interface CarDao {

public void createCar(Car c);
	
	//public void updateCustomer(Customer c);
	//public void preparedUpdateUser(User u)
	public void deleteCar(Car c);
	
	public Car getCarById(Integer id);
	
	public Car getUserByUsername(String name);
	
	public ArrayList<Car> getAllCars();
	
	public ArrayList<Car> getAllBiddedCars();
	
	public int insertCar(Car car);
	
	public void preparedUpdateCar(Car c);

	//void preparedUpdateUser(Customer c);
}
