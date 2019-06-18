package com.revature.ui;

import com.revature.pojo.Inventory;
import com.revature.util.Driver;
import com.revature.util.LoggingUtil;
//import com.revature.util.LoggingUtil;
import com.revature.util.TextValidator;

public class WelcomeScreen implements Screen {

	Inventory I;
	public WelcomeScreen(Inventory i) {
	
		I = i;
		display(I);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Screen display(Inventory I) {
		LoggingUtil.info("here is where I login OR register");
		TextValidator t = TextValidator.getInstance();
		int choice = t.askForInt(0, 4, "Welcome to Copart Custom Cars.", "Login", "Register");
		switch (choice){
			case 0:
				Driver.idao.saveFile(I);
				System.exit(0);
			case 1:
				
				return new LoginScreen(I);
			case 2:
				return new RegisterScreen(I);
		}	
		return null;
		
	}



	@Override
	public void printDisplay(Inventory i) {
		
		// TODO Auto-generated method stub
		
	}

}
