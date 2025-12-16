package model;

public class OrderDetails {
private int id;
private int orderid;
private int foodID;
private int quantity;
private double price;
public OrderDetails(int id, int orderid, int foodID, int quantity, double price) {
	super();
	this.id = id;
	this.orderid = orderid;
	this.foodID = foodID;
	this.quantity = quantity;
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getFoodID() {
	return foodID;
}
public void setFoodID(int foodID) {
	this.foodID = foodID;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
