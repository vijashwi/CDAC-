package src.com.in.squad.khanakhaza.pojo;

public class Login {

	String username;
	String TypeOfCustomer;
	String password;
	public String getUsername() {
		return username;
	}
	public String setUsername(String username) {
		return this.username = username;
	}
	public String getTypeOfCustomer() {
		return TypeOfCustomer;
	}
	public String setTypeOfCustomer(String typeOfCustomer) {
		return TypeOfCustomer = typeOfCustomer;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", TypeOfCustomer=" + TypeOfCustomer + ", password=" + password + "]";
	}
	
}
