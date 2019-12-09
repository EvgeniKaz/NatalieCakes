package javaBeans;

public class User {
private String userName;
private String password;
private String telephone;
private long id;

public User(String userName, String password, long id, String telephone) {
	super();
	this.telephone = telephone;
	this.userName = userName;
	this.password = password;
	this.id = id;
}

public User(String userName, String password, String telephone) {
	super();
	this.telephone = telephone;
	this.userName = userName;
	this.password = password;
}

public User() {
	super();
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}


public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}


}
