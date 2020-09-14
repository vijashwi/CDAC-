package src.com.in.squad.khanakhaza.dao;

import java.util.List;

import src.com.in.squad.khanakhaza.pojo.Orders;



public interface OrdersDao {

	boolean PlaceOrder(String email);
	List<Orders> ViewAll();
	List<Orders> SearchByEmail(String email);
	boolean DeleteById(int id);
	boolean DeleteAll();
}
