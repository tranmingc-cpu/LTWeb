package model;

import java.sql.Date;

public class Order {
private int Orderid;
private int accountId;
private Date orderDate;
private double totalAmount;
private String status;
public Order(int Orderid, int accountId, Date orderDate, double totalAmount, String status) {
	super();
	this.Orderid =Orderid;
	this.accountId = accountId;
	this.orderDate = orderDate;
	this.totalAmount = totalAmount;
	this.status = status;
}
public int getOrderid() {
	return Orderid;
}
public void setOrderid(int orderid) {
	Orderid = orderid;
}
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
}
