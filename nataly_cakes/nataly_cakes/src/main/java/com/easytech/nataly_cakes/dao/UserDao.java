package com.easytech.nataly_cakes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.stereotype.Repository;

import com.easytech.nataly_cakes.beans.User;
import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.enums.ErrorType;
import com.easytech.nataly_cakes.exceptions.ApplicationException;
import com.easytech.nataly_cakes.utils.JdbcUtils;

@Repository
public class UserDao {
	
	
	public UserDataCashe getUserDataByUserName(String userName) throws ApplicationException  {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = JdbcUtils.getConnection();

			String sqlStatement = "SELECT * FROM users WHERE userName=?";

			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, userName);

			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			Long userId = resultSet.getLong("ID");

			UserDataCashe userData = new UserDataCashe(userId);

			return userData;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}

	//---------------LOGIN---------------------


	
	public boolean logIn(String userName, String password) throws ApplicationException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sqlStatement = "SELECT * FROM users WHERE userName = ? && password = ?";
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				throw new ApplicationException(ErrorType.LOGIN_FAILED, "Your password doesn't fit user name: "+
						userName+ " or this user name does not exist");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	public long addUser(User user) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JdbcUtils.getConnection();

			String sqlStatement = "INSERT INTO users(userName, password, telephone) ";
			sqlStatement += "VALUES(?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlStatement,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getTelephone());

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			
			if (resultSet.next()) {
				long id = resultSet.getLong(1);
				return id;
			}
			else {
				throw new ApplicationException(ErrorType.FAILED_CREATE, "Failed to create id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}	
	}
	
	
	public void updateUser(User user) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = JdbcUtils.getConnection();

			String sqlStatement = "UPDATE users SET userName=?, password=?, telephone=? WHERE ID=?";

			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getTelephone());
			preparedStatement.setLong(4, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally

		{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}
	
	public User getOneUser(long userID) throws ApplicationException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			String sqlStatement = "SELECT * FROM users WHERE ID=?";

			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, userID);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			userID = resultSet.getLong("id");
			String userName = resultSet.getString("userName");
			String password = resultSet.getString("password");
			String telephone = resultSet.getString("telephone");
			

			User user = new User(password,userName, userID, telephone);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	public void deleteUser(long userID) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			String sqlStatement = "DELETE FROM users WHERE ID=?";
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, userID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}
}
