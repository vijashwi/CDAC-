package src.com.in.squad.khanakhaza.pojo;

public class Orders {

	int order_id;
	String cust_email;
	int total_bill;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public int getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", cust_email=" + cust_email + ", total_bill=" + total_bill + "]";
	}
	
	
}
