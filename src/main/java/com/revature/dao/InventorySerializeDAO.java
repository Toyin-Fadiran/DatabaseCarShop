package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Inventory;


public class InventorySerializeDAO implements InventoryDAO {

	private static final String FILENAME = "myInventory.dat";

	@Override
	public void saveFile(Inventory i) {
		ObjectOutputStream oos = null;
		FileOutputStream foo = null;

		try {
			foo = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(foo);
			oos.writeObject(i);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
			try {
				if (foo != null) foo.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}

	}

	@Override
	public Inventory loadFile() {
		Inventory ret = null;

		//try with resources
		try (FileInputStream fis = new FileInputStream(FILENAME);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			ret = (Inventory) ois.readObject();

		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
		//	e.printStackTrace();
		} catch (ClassNotFoundException e) {
		//	e.printStackTrace();
		}

		return ret;
	}

}
