package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojo.Car;
import com.revature.pojo.Offer;
import com.revature.util.ConnectionFactory;

public class OfferDaoImpl implements OfferDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void insertOffer(Offer o) {
		String sql = "insert into project_offer(customerid, carid, status_id, offer_price)" + "values(?,?,?,?);";

		PreparedStatement pstmt;
		//int newId = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, o.getCustomerid());
			pstmt.setInt(2, o.getCarid());
			pstmt.setInt(3, o.getStatus_id());
			pstmt.setDouble(4, o.getOffer_price());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

		
	}

	@Override
	public ArrayList<Offer> getOffersbyCarID(Integer id) {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		String sql = "select * from project_offer where carid = " + id;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				carList.add(new Car(, , rs.getDouble("car_price"),
//						rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
				
				offers.add(new Offer(rs.getInt(1), rs.getInt("customerid"), rs.getInt("carid"), 
						rs.getInt("status_id"), rs.getDouble("offer_price")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public int getCustomerIDbyofferID(Integer offerChosen) {
		String sql = "select * from project_offer where offer_id = " + offerChosen;
		Offer ret = null;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				ret = new Offer(rs.getInt("offer_id"), rs.getInt("customerid"),
						rs.getInt("carid"), rs.getInt("status_id"), rs.getDouble("offer_price"));

			//	offers.add(new Offer(rs.getInt(1), rs.getInt("customerid"), rs.getInt("carid"), 
			//			rs.getInt("status_id"), rs.getDouble("offer_price")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret.getCustomerid();
	
	}

}
