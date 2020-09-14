package src.com.in.squad.khanakhaza.dao;

import src.com.in.squad.khanakhaza.pojo.Food;


public interface FoodDao {

	boolean add_food(Food f);
	boolean edit(Food f);
	boolean deletefoodname(String e);
	boolean deleteByid(int id);
	boolean deleteAll();
	List<Food> ShowAll();
	Food SearchByid(int id);
	List<Food> SearchByname(String e);
	List<Food> SearchBytype(String t);
}
