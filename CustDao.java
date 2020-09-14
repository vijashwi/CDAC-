package src.com.in.squad.khanakhaza.dao;

import java.util.List;

import src.com.in.squad.khanakhaza.pojo.Customer;


public interface CustDao {

	boolean cust_add(Customer cust);
	boolean cust_edit(Customer cust);
	boolean delete(int id);
	List<Customer> ShowAll();
	Customer Searchbyid(int id);
	List<Customer> Searchbyname(String e);
	boolean deleteall();
	List<Customer> Searchbykeyword(String e);
}
