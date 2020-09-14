package src.com.in.squad.khanakhaza.pojo;

public class Cart {

	int cart_id;
	String cust_email;
	int food_id;
	int food_qty;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getFood_qty() {
		return food_qty;
	}
	public void setFood_qty(int food_qty) {
		this.food_qty = food_qty;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", cust_email=" + cust_email + ", food_id=" + food_id + ", food_qty="
				+ food_qty + "]";
	}
	
	
}
