package com.revature.ui;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojo.Car;
import com.revature.pojo.Inventory;
import com.revature.pojo.User;
import com.revature.services.UserService;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;
import com.revature.util.TextValidator;



public class LoginScreen implements Screen {

//	private static EmployeeDao empDao = new EmployeeDaoImpl();
	private static EmployeeDao empDao = new EmployeeDaoImpl(ConnectionFactory.getConnection());

	Inventory I2;

	public LoginScreen(Inventory I) {
		I2 = I;
		display(I2);
	}

	@Override
	public Screen display(Inventory I2) {
		LoggingUtil.info("here is where I verify password");
		TextValidator t = TextValidator.getInstance();
		boolean x = true;
		// UserService s = UserService.getInstance();
		while (x == true) {
			String empOrCust = t.askForString(1, 25, "Employee(E) or Customer(C)? ");

			if ("e".equals(empOrCust.toLowerCase())) {
				String tempFirst = t.askForString(1, 25, "LOGIN: PLEASE ENTER First  NAME: ");
				String tempLast = t.askForString(1, 25, "LOGIN: PLEASE ENTER last  NAME: ");
				String tempPass = t.askForString(1, 25, "Please enter your password.");

				User tempUser = new User(tempFirst, tempLast, tempPass, null);

				String databaseName = empDao.getEmployeeByName(tempFirst).getFirstName();
				String databasePass = empDao.getEmployeeByName(tempFirst).getPassword();

				if (tempUser.getFirstName().equals(databaseName) && tempPass.equals(databasePass)) {
					x = false;
					return new EmployeeScreen(I2);
				}
				
			}
			
			if ("c".equals(empOrCust.toLowerCase())) {
				return new DashboardScreen(I2);
			}
		}
	//	x= false;
		return new LoginScreen(I2);

	}

////			if (tempUser == null) continue; 
//			if (tempPass.equals(tempUser.getPassword() )){
//				return new DashboardScreen(I2);
//			}

//		String tempFirst = t.askForString(1, 25, "LOGIN: PLEASE ENTER First  NAME: ");
//		//tempUser = s.getByFirstName(tempFirst);
//		User tempUser = s.getByFirstName(tempFirst);
//		
//		if (tempUser == null) continue; 
//		String tempPass = t.askForString(1, 25, "Please enter your password.");
//		
//		if (  tempUser.getFirstName().equals("admin") && tempPass.equals("admin")   ) {
//			return new EmployeeScreen(I2);
//		}
//		if (tempPass.equals(tempUser.getPassword() )){
//			return new DashboardScreen(I2);
//		}
//		//
//		//if(tempPass.equals("admin")) {
//		//	return new EmployeeScreen();
//	//	}

	@Override
	public void printDisplay(Inventory I2) {

		// TODO Auto-generated method stub

	}

}
