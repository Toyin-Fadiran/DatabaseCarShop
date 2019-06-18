package com.revature.util;

import java.io.Serializable;
import java.util.Scanner;

public class TextValidator implements Serializable {

	static TextValidator t = null;


	private TextValidator() {}

	public static TextValidator getInstance() {
		if (t == null) {
			t = new TextValidator();
		}
		return t;
	}
	
	private String getInput() {
		return new Scanner(System.in).nextLine();
	}
	
	private String getString(int minLength, int maxLength) {
		while(true) {
		String returnVar = getInput();
		if( returnVar.length() >= minLength && returnVar.length() <= maxLength) return returnVar;
		System.out.println("Invalid entry. Input must be between " + minLength + " and " + maxLength + ".");
		}
	}
	
	private int getInt(int min, int max) {
		int returnVar = 0;
		while(true) {
			try {
		 returnVar = Integer.parseInt(getInput());
			} catch(NumberFormatException e ) {
				System.out.println("Invalid entry. Please try entering a number between " + min + " and " + max + ".");
			}
		if( returnVar >= min && returnVar <= max) return returnVar;
		System.out.println("Invalid entry. Input must be  between " + min + " and " + max + ".");
		
			} 
	}
	
	private double getDouble(double min, double max) {
		double returnVar = 0;
		while(true) {
			try {
		 returnVar = Double.parseDouble(getInput());
			} catch(NumberFormatException e ) {
				System.out.println("Invalid entry. Please try entering a number between " + min + " and " + max + ".");
			}
		if( returnVar >= min && returnVar <= max) return returnVar;
		System.out.println("Invalid entry. Input must be  between " + min + " and " + max + ".");
		
			} 
	}
	
	public String askForString (int minLength, int maxLength, String ... prompt) {
		printPrompt(prompt);
		
		String returnVar = getString(minLength, maxLength);
		
		return returnVar;
	}
	
	
	
	public int askForInt(int min, int max, String ... prompt) {
		printPrompt(prompt);
		return getInt(min, max);
	}
	
	public double askForDouble(double min, double max, String ... prompt) {
		printPrompt(prompt);
		return getDouble(min, max);
	}
	
	private void printPrompt(String[] prompt) {
		System.out.println("=================================================");
		System.out.println(prompt[0]);
		for (int i=1; i<prompt.length; i++) {
			System.out.println(i + ". " + prompt[i] );
		}
	}

}
