package javaBeans;

public class User {
private String userName;
private String password;
private long id;

public User(String userName, String password, long id) {
	super();
	this.userName = userName;
	this.password = password;
	this.id = id;
}

public User(String userName, String password) {
	super();
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



}
