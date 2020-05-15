package com.qa.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class item {
	
	int product_ID;
	String name;
	Double price;
	int stock;
	
	public item(int product_IDPassed, String namePassed, Double pricePassed, int stockPassed) {
		product_ID = product_IDPassed;
		name = namePassed;
		price = pricePassed;
		stock = stockPassed;
	}
	
	public item queryItem(int productID) {
		String query = "SELECT * from item where productID = " + productID;
		int product_IDtemp = 0;
		String nametemp = null;
		Double pricetemp = null;
		int stocktemp = 0;
		
		ResultSet rs = JDBCDriver.exQuery(query);
		try {
			while(rs.next()) {
				product_IDtemp = rs.getInt("product_ID");
				nametemp = rs.getString("name");
				pricetemp = rs.getDouble("price");
				stocktemp = rs.getInt("stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new item(product_IDtemp, nametemp, pricetemp, stocktemp);
	}
	
	public void insertSelf() {
		String query = "INSERT INTO item VALUES("+this.product_ID+",'"+this.name
				+"',"+this.price+","+this.stock+")";
		JDBCDriver.exUpdate(query);
	}
	
}
