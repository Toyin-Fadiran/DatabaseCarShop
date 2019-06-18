package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;



public class CarDaoImpl implements CarDao {

	private static Connection conn = ConnectionFactory.getConnection();
	// List<Car> carList = new ArrayList<Car>();

	public CarDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createCar(Car c) {
//		try {//Connection conn =DriverManager.getConnection(url, user, password);
//			conn = ConnectionFactory.getConnection();
//			Statement stmt = conn.createStatement();
//			conn.setAutoCommit(false);
//			Savepoint sp = conn.setSavepoint("Before Create");
//			String query = "insert into project_car values (DEFAULT, '" + c.getName() + "' , '" + c.getPrice() + "'  )";
//			//(DEFAULT, '" + c.getFirstName() + "' , '" + c.getLastName() + "' , '" + c.getPassword() + "'  )";
//			stmt.executeUpdate(query);
//			//LoggingUtil.info(msg);
//			conn.commit();
//			conn.setAutoCommit(true);
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//	

		// pstmt;

		try {
			conn.setAutoCommit(false);
			String query = "insert into project_car(car_name, car_price) values(?,?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			// pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, c.getName());
			pstmt.setDouble(2, c.getPrice());
			Savepoint sp = conn.setSavepoint("Before Create");
			boolean check = pstmt.execute();
			// if(check) {
			// System.out.println(c.getName() + "successfully added to lot;");
			// }
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCar(Car c) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update project_car set for_sale = ? where carid = ?");
			pstmt.setBoolean(1, c.getForSale());
			pstmt.setInt(2, c.getCarID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@Override
	public Car getCarById(Integer id) {
		Car ret = null;
		String sql = "select * from project_car where carid =" + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new Car();
				// new Car(
				ret.setCarID(rs.getInt(1));

				ret.setCarID(rs.getInt(1));
				ret.setName(rs.getString("car_name"));
				ret.setPrice(rs.getDouble("car_price"));
				ret.setForSale(rs.getBoolean("for_sale"));
				ret.setOfferFlag(rs.getBoolean("offer_flag"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Car getUserByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
//	public List<Car> getAllCars() {
//		List<Car> carList = new ArrayList<>();
//		
//		String sql = "select * from project_car where offer for_sale = true";
//try {
//			
//			Statement stmt = conn.createStatement();
//			conn.setAutoCommit(false);  //needs to be done to run transactions
//			Savepoint sp = conn.setSavepoint("Before returning cars");
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				carList.add(new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getBoolean(5)));
//				
//				conn.commit();
//				conn.setAutoCommit(true);
//			}
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}

//
//return carList;
//}

	@Override
	public int insertCar(Car car) {
		String sql2 = "insert into car(car_name, price)" + "values(?,?);";

		PreparedStatement pstmt;
		int newId = 0;

		try {
			pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, car.getName());
			pstmt.setDouble(2, car.getPrice());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				newId = rs.getInt(1);
			}

		} catch (SQLException e) {
			// LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

		return newId;
	}

	@Override
	public ArrayList<Car> getAllCars() {
		ArrayList<Car> carList = new ArrayList<>();

		String sql = "select * from project_car where for_sale = true";
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				carList.add(new Car(, , rs.getDouble("car_price"),
//						rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
				
				carList.add(new Car(rs.getInt(1), rs.getInt("customerid"), rs.getString("car_name"), 
						rs.getDouble("car_price"), rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carList;
	}

	@Override
	public void preparedUpdateCar(Car c) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update project_car set offer_flag = ? where carid = ?");
			pstmt.setBoolean(1, c.getOfferFlag());
			pstmt.setInt(2, c.getCarID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Car> getAllBiddedCars() {
		ArrayList<Car> carList = new ArrayList<>();

		String sql = "select * from project_car where offer_flag = true";
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				carList.add(new Car(, , rs.getDouble("car_price"),
//						rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
				
				carList.add(new Car(rs.getInt(1), rs.getInt("customerid"), rs.getString("car_name"), 
						rs.getDouble("car_price"), rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carList;
	}

	//

	// Statement.RETURN_GENERATED_KEYS)
	// rs = stmt.getGeneratedKeys();
//		
//        rs = stmt.getGeneratedKeys();
//        while (rs.next()) {
//            System.out.println("Key returned from getGeneratedKeys():"
//                    + rs.getInt(1));
//        } 
//        rs.close();
//

//		  public static void main(String[] args) {
//		        Statement stmt = null;
//		        ResultSet rs = null;
//		        Connection conn = null;
//		        try {
//		            conn = getConnection();
//		            stmt = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,
//		                                        java.sql.ResultSet.CONCUR_UPDATABLE);
//
//		            stmt.executeUpdate("DROP TABLE IF EXISTS autoincSample");
//		            stmt.executeUpdate(
//		                    "CREATE TABLE autoincSample ("
//		                    + "id INT NOT NULL AUTO_INCREMENT, "
//		                    + "data VARCHAR(64), PRIMARY KEY (id))");
//
//		            stmt.executeUpdate(
//		                    "INSERT INTO autoincSample (data) "
//		                    + "values ('Record ----- 1')",
//		                    Statement.RETURN_GENERATED_KEYS);
//
//		            rs = stmt.getGeneratedKeys();
//		            while (rs.next()) {
//		                System.out.println("Key returned from getGeneratedKeys():"
//		                        + rs.getInt(1));
//		            } 
//		            rs.close();

}
