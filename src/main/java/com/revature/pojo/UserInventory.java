package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserInventory implements Serializable {

private static UserInventory c = null;
	
	public static List<User> users = new ArrayList<>();
	
	
	private UserInventory () {};
	
	public static UserInventory getInstance() {
		if (c == null)
			c = new UserInventory();
		return c;
	}
	
	public Object readResolve() {
		return getInstance();
	}

}
