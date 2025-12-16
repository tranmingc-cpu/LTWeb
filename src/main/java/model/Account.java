package model;

public class Account {
private int idAccount;
private String userName;
private String password;
private String email;
private int number;
private String address;
private boolean role;
public Account(int idAccount, String userName, String password, String email, int number, String address,
		boolean role) {
	super();
	this.idAccount = idAccount;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.number = number;
	this.address = address;
	this.role = role;
}
public int getIdAccount() {
	return idAccount;
}
public void setIdAccount(int idAccount) {
	this.idAccount = idAccount;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean getRole() {
	return role;
}
public void setRole(boolean role) {
	this.role = role;
}


}
