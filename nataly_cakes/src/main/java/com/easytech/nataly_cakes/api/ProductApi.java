package com.easytech.nataly_cakes.api;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easytech.nataly_cakes.beans.Product;
import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.exceptions.ApplicationException;
import com.easytech.nataly_cakes.logic.ProductController;

@RestController
@RequestMapping("/product")

public class ProductApi {
	@Autowired
	private ProductController productController = null;
	@PostMapping
	public void createProduct(@RequestParam("token") int token,@RequestBody Product product,HttpServletRequest request) throws ApplicationException{
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		productController.createProduct(product, userDataCache);
	}
	@GetMapping ("/{productId}")
	public void getProductById(@RequestParam("token") int token,@PathVariable("productId") long id,HttpServletRequest request) throws ApplicationException, ParseException {
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		productController.getProductById(userDataCache, id);
	}
	@GetMapping 
	public void getAllProducts(@RequestParam("token") int token, HttpServletRequest request) throws ApplicationException, ParseException {
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		productController.getAllProducts(userDataCache);
	}
	@PutMapping
	public void updateProduct(@RequestParam("token") int token,@RequestBody Product product,HttpServletRequest request) throws ApplicationException{
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		productController.updateProduct(product, userDataCache);
	}
	@DeleteMapping("/{productId}")
	public void deleteUser(@RequestParam("token") int token,@PathVariable("productId") long id,HttpServletRequest request) throws ApplicationException {
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		productController.deleteProduct(userDataCache, id);
	}
}
