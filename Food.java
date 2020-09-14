package src.com.in.squad.khanakhaza.pojo;

public class Food {

	int food_id;
	int food_cost;
	String food_name;
	String food_type;
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getFood_cost() {
		return food_cost;
	}
	public void setFood_cost(int food_cost) {
		this.food_cost = food_cost;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_cost=" + food_cost + ", food_name=" + food_name + ", food_type="
				+ food_type + "]";
	}
	
	
	
}
