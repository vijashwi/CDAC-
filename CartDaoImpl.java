package src.com.in.squad.khanakhaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.in.squad.khanakhaza.dbutil.Dbutility;
import src.com.in.squad.khanakhaza.pojo.Cart;

public class CartDaoImpl implements CartDao {
	Connection con;
	PreparedStatement ps;
	int flag;

	@Override
	public boolean add_cart(Cart c) {
		con = Dbutility.getcon();
		c=checkIfFoodAdded(c);
		if(c.getFood_qty()==0)
		{
		String str = "insert into cart_ct021(cust_email,food_id,food_qty)values(?,?,?)";
		try {
			ps = con.prepareStatement(str);
			ps.setString(1, c.getCust_email());
			ps.setInt(2, c.getFood_id());
			ps.setInt(3, 1);
			flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			updatecart(c);
		}
		return false;
	}

	private Cart checkIfFoodAdded(Cart c) {
		con = Dbutility.getcon();
		String str7="select * from cart_ct021  where cust_email=? and  	food_id =?";
		try {
			ps=con.prepareStatement(str7);
			ps.setString(1,c.getCust_email());
			ps.setInt(2, c.getFood_id());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setCart_id(rs.getInt(1));
				c.setFood_qty(rs.getInt(4)+1);
				return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<Cart> ViewAll() {
		List<Cart> li = new ArrayList<>();

		con = Dbutility.getcon();
		String str1 = "select * from cart_ct021";
		try {
			ps = con.prepareStatement(str1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setCart_id(rs.getInt(1));
				c.setFood_id(rs.getInt(2));
				c.setCust_email(rs.getString(3));
				c.setFood_qty(rs.getInt(4));
				li.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Cart> SearchByEmail(String email) {
		List<Cart> lis = new ArrayList<>();

		con = Dbutility.getcon();
		String str2 = "select * from cart_ct021 where cust_email=?";
		try {
			ps = con.prepareStatement(str2);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setCart_id(rs.getInt(1));
				c.setFood_id(rs.getInt(2));
				c.setCust_email(rs.getString(3));
				c.setFood_qty(rs.getInt(4));
				lis.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}

	@Override
	public boolean DeleteByEmail(String email) {
		con = Dbutility.getcon();
		String str3 = "delete from cart_ct021 where cust_email=?";
		try {
			ps = con.prepareStatement(str3);
			ps.setString(1, email);
			flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean DeleteAll() {
		con = Dbutility.getcon();
		String str4 = "truncate cart_ct021";
		try {
			ps = con.prepareStatement(str4);
			flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> ShowAll() {
		List<Cart> fli = new ArrayList<>();
		con = Dbutility.getcon();
		String str5 = "select * from cart_ct021";
		try {
			ps = con.prepareStatement(str5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setCart_id(rs.getInt(1));
				c.setFood_id(rs.getInt(2));
				c.setCust_email(rs.getString(3));
				c.setFood_qty(rs.getInt(4));
				fli.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fli;
	}

	@Override
	public boolean DeleteById(int id) {
		con = Dbutility.getcon();
		String str6 = "delete from cart_ct021 where cart_id=?";
		try {
			ps = con.prepareStatement(str6);
			ps.setInt(1, id);
			flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatecart(Cart c) {
		con = Dbutility.getcon();
		String str7="update cart_ct021 set food_qty=? where cart_id=?";
		try {
			ps=con.prepareStatement(str7);
			ps.setInt(1,c.getFood_qty());
			ps.setInt(2, c.getCart_id());
			flag=ps.executeUpdate();
			if(flag>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	

}
