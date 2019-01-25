package com.infogain.app.authorization;

public class JwtUser {
private String email;
private String password;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public JwtUser() {
	super();
	// TODO Auto-generated constructor stub
}
public JwtUser(String email, String password) {
	
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "JwtUser [email=" + email + ", password=" + password + "]";
}

}
