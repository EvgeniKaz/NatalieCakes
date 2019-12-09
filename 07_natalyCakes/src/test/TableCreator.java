package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import utils.JdbcUtils;


public class TableCreator {
//-------------------FINAL STRINGS TABLE NAMES FOR CHECK METHODS-----------------
	static final String tableNameProducts = "products";
	static final String tableNameUsers = "users";

//-------------------CREATE TABLE STATEMENTS-----------------------


	static final String productTableCreateCommand = "CREATE TABLE products ("
			+ "ID BIGINT  PRIMARY KEY AUTO_INCREMENT, " + 
			"productType VARCHAR(100) NOT NULL, " +
			"name VARCHAR(100) NOT NULL, " +
			"description VARCHAR(100) NOT NULL, " +
			"price DOUBLE NOT NULL, " +
			"image VARCHAR(100) NOT NULL)";

	static final String userTableCreateCommand = "CREATE TABLE users (" 
			+ "ID BIGINT PRIMARY KEY AUTO_INCREMENT, "
			+ "userName VARCHAR(100) NOT NULL, " 
			+ "telephone VARCHAR(100) NOT NULL, " 
			+ "password VARCHAR(14) NOT NULL)";

	/**
	 * This method creates tables
	 * 
	 * @param sqlTable
	 * @throws SQLException
	 */
	public void buildDB(String sqlTable) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = JdbcUtils.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sqlTable);

			System.out.println("table has been created.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.close();
		}
	}

	public void dropDB(String tableName) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = JdbcUtils.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE " + tableName);

			System.out.println("table has been droped.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.close();
		}
	}

}