package com.easytech.nataly_cakes.api;



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

import com.easytech.nataly_cakes.beans.LogIn;
import com.easytech.nataly_cakes.beans.User;
import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.beans.UserDataClient;
import com.easytech.nataly_cakes.exceptions.ApplicationException;
import com.easytech.nataly_cakes.logic.UserController;

@RestController
@RequestMapping("/user")
public class UserApi {
	@Autowired
	private UserController userController = null;

	
	@PostMapping()
	public void register(@RequestBody User user) throws ApplicationException {
		userController.createUser(user);
		
	}
	@PostMapping("/login")
	public UserDataClient login(@RequestBody LogIn login) throws ApplicationException {
		return userController.login(login);
	}
	@PutMapping
	public void updateUser(@RequestParam("token") int token,@RequestBody User user,HttpServletRequest request) throws ApplicationException{
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		userController.updateUser(user, userDataCache);
	}
	@DeleteMapping("/{userId}")
	public void deleteUser(@RequestParam("token") int token,@PathVariable("userId") long id,HttpServletRequest request) throws ApplicationException {
		UserDataCashe userDataCache = (UserDataCashe) request.getAttribute("userData");
		userController.deleteUser(userDataCache, id);
	}


}
