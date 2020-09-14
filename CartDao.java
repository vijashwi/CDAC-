package src.com.in.squad.khanakhaza.dao;

import java.util.List;

import src.com.in.squad.khanakhaza.pojo.Cart;


public interface CartDao {

	
	boolean add_cart(Cart c);
	List<Cart> ViewAll();
	List<Cart> ShowAll();
	List<Cart> SearchByEmail(String email);
	boolean DeleteByEmail(String email);
	boolean DeleteById(int id);
	boolean DeleteAll();
	boolean updatecart(Cart c);
	
}
