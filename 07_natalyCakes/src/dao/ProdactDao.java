package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import enums.ErrorType;
import enums.ProductType;
import exeptions.ApplicationException;
import javaBeans.Product;
import utils.JdbcUtils;

public class ProdactDao {
	
	
	public long addProduct(Product product) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = JdbcUtils.getConnection();

			String sqlStatement = "INSERT INTO products(name, price, description, image, productType) ";
			sqlStatement += "VALUES(?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlStatement,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setString(5, product.getProductType().name());

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
	
	
	public void updateProduct(Product product) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = JdbcUtils.getConnection();

			String sqlStatement = "UPDATE products SET name=?, price=?, description=?, image=?, productType=? WHERE ID=?";

			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setString(5, product.getProductType().name());
			preparedStatement.setLong(6, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally

		{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}
	
	public Product getOneProduct(long productID) throws ApplicationException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			String sqlStatement = "SELECT * FROM products WHERE ID=?";

			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, productID);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			productID = resultSet.getLong("id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			String image = resultSet.getString("image");
			double price = resultSet.getDouble("price");
			ProductType productType = ProductType.valueOf(resultSet.getString("productType"));

			Product product = new Product(productType, name, price, description, productID, image);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	public ArrayList<Product> getAllProducts() throws ApplicationException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			String sqlStatement = "SELECT * FROM products";

			preparedStatement = connection.prepareStatement(sqlStatement);
			resultSet = preparedStatement.executeQuery();
			
			ArrayList<Product> allProducts = new ArrayList<Product>();
			while (resultSet.next()) {
			long productID = resultSet.getLong("id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			String image = resultSet.getString("image");
			double price = resultSet.getDouble("price");
			ProductType productType = ProductType.valueOf(resultSet.getString("productType"));

			Product product = new Product(productType, name, price, description, productID, image);
			allProducts.add(product);
			}
			
			return allProducts;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
	}
	public void deleteProduct(long productID) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			String sqlStatement = "DELETE FROM products WHERE ID=?";
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setLong(1, productID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorType.GENERAL_ERROR, "Please try again later");
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}
}
