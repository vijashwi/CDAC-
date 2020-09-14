package src.com.in.squad.khanakhaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.in.squad.khanakhaza.dbutil.Dbutility;
import src.com.in.squad.khanakhaza.pojo.Orders;




public class OrdersDaoImpl implements OrdersDao {

	Connection con;
	PreparedStatement ps;
	int flag;

	@Override
	public boolean PlaceOrder(String email) {
		int total_bill = 0;

		con = Dbutility.getcon();
//		String str="";
		try {
//			ps=con.prepareStatement(str);

			String str1 = " select (sum(food_qty*food_cost)) as bill  from cart_ct021 inner join food_ct021 on cart_ct021.food_id=food_ct021.food_id where cust_email=?";
			ps = con.prepareStatement(str1);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				total_bill = rs.getInt(1);
			}
			String str2 = "insert into orderrs(cust_email,total_bill)values(?,?)";
			ps = con.prepareStatement(str2);
			ps.setString(1, email);
			ps.setInt(2, total_bill);
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
	public List<Orders> ViewAll() {
		
		List<Orders> li = new ArrayList<>();
		con=Dbutility.getcon();
		String str1="select * from orderrs";
		try {
			ps=con.prepareStatement(str1);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders oo=new Orders();
				oo.setCust_email(rs.getString(2));
				oo.setOrder_id(rs.getInt(1));
				oo.setTotal_bill(rs.getInt(3));
				li.add(oo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Orders> SearchByEmail(String email) {
		con=Dbutility.getcon();
		List<Orders> lis = new ArrayList<>();
		String str2="select * from orderrs where cust_email=?";
		try {
			ps=con.prepareStatement(str2);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders oo=new Orders();
				oo.setCust_email(rs.getString(2));
				oo.setOrder_id(rs.getInt(1));
				oo.setTotal_bill(rs.getInt(3));
				lis.add(oo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}

	@Override
	public boolean DeleteById(int id) {
	con=Dbutility.getcon();
	String str3="delete from orderrs where orderr_id=?";
	try {
		ps=con.prepareStatement(str3);
		ps.setInt(1,id);
		flag=ps.executeUpdate();
		if(flag>0) {
			return true;
		}
		else {
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
		con=Dbutility.getcon();
		String str4="Truncate orderrs";
		try {
			ps=con.prepareStatement(str4);
			flag=ps.executeUpdate();
			if(flag>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
