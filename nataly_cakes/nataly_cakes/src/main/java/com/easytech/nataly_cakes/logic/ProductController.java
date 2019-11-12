package com.easytech.nataly_cakes.logic;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.easytech.nataly_cakes.beans.Product;
import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.dao.ProductDao;
import com.easytech.nataly_cakes.enums.ErrorType;
import com.easytech.nataly_cakes.exceptions.ApplicationException;

@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao = new ProductDao();

	private boolean isCreateProductValid(Product product, UserDataCashe userDataCashe) throws ApplicationException {

		return true;
	}
	private boolean isUpdateProductValid(Product product, UserDataCashe userDataCashe) throws ApplicationException {

		return true;
	}

	public void createProduct(Product product, UserDataCashe userDataCashe) throws ApplicationException {
		if (isCreateProductValid(product, userDataCashe)) {
			productDao.addProduct(product);
		} else
			throw new ApplicationException(ErrorType.FAILED_CREATE, " failed create product");
	}
	public ArrayList<Product> getAllProducts() throws ApplicationException, ParseException {
		return productDao.getAllProducts();
	}
	public Product getProductByName(UserDataCashe userDataCashe, String productName) throws ApplicationException, ParseException {
		return productDao.getProductByName(productName);
	}
	public Product getProductById(long productId) throws ApplicationException, ParseException {
		return productDao.getOneProduct(productId);
	}
	public void deleteProduct(UserDataCashe userDataCashe, long productId) throws ApplicationException {
		productDao.deleteProduct(productId);
	}
	public void updateProduct(Product product, UserDataCashe userDataCashe) throws ApplicationException {
		if (isUpdateProductValid(product, userDataCashe)) {
			productDao.updateProduct(product);
		} else
			throw new ApplicationException(ErrorType.FAILED_CREATE, " failed update product");
	}
}
