package com.easytech.nataly_cakes.logic;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.easytech.nataly_cakes.beans.LogIn;
import com.easytech.nataly_cakes.beans.User;
import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.beans.UserDataClient;
import com.easytech.nataly_cakes.cashe.ICacheManager;
import com.easytech.nataly_cakes.dao.UserDao;
import com.easytech.nataly_cakes.enums.ErrorType;
import com.easytech.nataly_cakes.exceptions.ApplicationException;

@Controller
public class UserController {
	@Autowired
	private ICacheManager cacheManager;
	@Autowired
	private UserDao userDao = new UserDao();
	
	public UserDataClient login(LogIn login) throws ApplicationException {
		int token = generateEncryptedToken(login.getUserName());
		UserDataCashe userData = userDao.getUserDataByUserName(login.getUserName());

		cacheManager.put(token, userData);

		UserDataClient userDataClient = new UserDataClient(token, userData.getUserID(),login.getUserName());
		return userDataClient;
	}

	private int generateEncryptedToken(String userName) {
		String token = userName + (Math.random() * 100000) + 1;
		return token.hashCode();

	}

	
	private boolean isCreateUserValid(User user) throws ApplicationException {

		return true;
	}
	private boolean isUpdateUsertValid(User user, UserDataCashe userDataCashe) throws ApplicationException {

		return true;
	}

	public void createUser(User user) throws ApplicationException {
		if (isCreateUserValid(user)) {
			userDao.addUser(user);
		} else
			throw new ApplicationException(ErrorType.FAILED_CREATE, " failed create user");
	}
	public User getUserById(UserDataCashe userDataCashe, long userId) throws ApplicationException, ParseException {
		return userDao.getOneUser(userId);
	}
	public void deleteUser(UserDataCashe userDataCashe, long userId) throws ApplicationException {
		userDao.deleteUser(userId);
	}
	
	public void updateUser(User user, UserDataCashe userDataCashe) throws ApplicationException {
		if (isUpdateUsertValid(user, userDataCashe)) {
			userDao.updateUser(user);
		} else
			throw new ApplicationException(ErrorType.FAILED_CREATE, " failed update user");
	}
}
