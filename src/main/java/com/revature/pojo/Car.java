package com.revature.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.revature.dao.CarDaoImpl;

public class Car implements Serializable {

	private String name;
	private Integer carID;
	private Integer customeriD;
	private Double price;
	private Boolean offerFlag = false;
	CarLot cl = CarLot.getInstance();
//	CarDaoImpl car = new CarDaoImpl();
	private Boolean forSale = true;
	
	

	@Override
	public String toString() {
		return "Car [name=" + name + ", carID=" + carID + ", customeriD=" + customeriD + ", price=" + price
				+ ", offerFlag=" + offerFlag + ", forSale=" + forSale + "]";
	}


	public Car() {
		super();
	}

	
	public Car(Integer carID, Integer customeriD, String name, Double price, Boolean forSale, Boolean offerFlag, Inventory i ) {
		this.carID = carID;
		this.name = name;
		this.price = price;
		this.forSale = forSale;
		this.offerFlag = offerFlag;
		
		this.customeriD = customeriD;
		
		cl.carLot.put(name, this);	
	}
	
	public Car(Integer carID, Integer customeriD, String name, Double price, Boolean forSale, Boolean offerFlag ) {
		this.carID = carID;
		this.name = name;
		this.price = price;
		this.offerFlag = false;
		this.forSale = forSale;
		this.offerFlag = offerFlag;
		this.customeriD = customeriD;
		cl.carLot.put(name, this);	
	}

	
	public Car( Integer customeriD, String name, Double price, Boolean forSale,Boolean offerFlag,  Inventory i ) {
		//this.carID = carID;
		this.name = name;
		this.price = price;
		this.offerFlag = false;
		this.forSale = forSale;
		this.offerFlag = offerFlag;
		
		this.customeriD = customeriD;
		
		cl.carLot.put(name, this);
		
	}
	
	
	public Car( Integer customeriD, String name, Double price, Boolean forSale, Boolean offerFlag ) {
		//this.carID = carID;
		this.name = name;
		this.price = price;
		this.offerFlag = offerFlag;
		this.forSale = forSale;
		this.customeriD = customeriD;
		cl.carLot.put(name, this);	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getCarID() {
		return carID;
	}


	public void setCarID(Integer carID) {
		this.carID = carID;
	}


	public Integer getCustomeriD() {
		return customeriD;
	}


	public void setCustomeriD(Integer customeriD) {
		this.customeriD = customeriD;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Boolean getOfferFlag() {
		return offerFlag;
	}


	public void setOfferFlag(Boolean offerFlag) {
		this.offerFlag = offerFlag;
	}


	public Boolean getForSale() {
		return forSale;
	}


	public void setForSale(Boolean forSale) {
		this.forSale = forSale;
	}
	

}
