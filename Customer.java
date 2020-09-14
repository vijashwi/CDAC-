package src.com.in.squad.khanakhaza.pojo;

public class Customer {

	int cust_id;
	String mobile_num;
	String cust_name;
	String cust_email;
	String cust_add;
	String cust_password;
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_add() {
		return cust_add;
	}
	public void setCust_add(String cust_add) {
		this.cust_add = cust_add;
	}
	public String getCust_password() {
		return cust_password;
	}
	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", mobile_num=" + mobile_num + ", cust_name=" + cust_name
				+ ", cust_email=" + cust_email + ", cust_add=" + cust_add + ", cust_password=" + cust_password + "]";
	}
	
	
	
}
