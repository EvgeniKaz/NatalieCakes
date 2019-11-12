package com.easytech.nataly_cakes.beans;


public class UserDataClient {
private int token;
private long  id;
private String userName;
public UserDataClient(int token, long id, String userName) {
	super();
	this.token = token;
	this.id = id;
	this.userName = userName;
}
public UserDataClient() {
	super();
	// TODO Auto-generated constructor stub
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getToken() {
	return token;
}
public void setToken(int token) {
	this.token = token;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}


}
