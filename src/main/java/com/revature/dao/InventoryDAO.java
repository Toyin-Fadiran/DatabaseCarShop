package com.revature.dao;

import com.revature.pojo.Inventory;

public interface InventoryDAO {

	public void saveFile(Inventory i);
		
		public Inventory loadFile();

	}


