package src.com.in.squad.khanakhaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.in.squad.khanakhaza.dbutil.Dbutility;
import src.com.in.squad.khanakhaza.pojo.Food;



public class FoodDaoImpl implements FoodDao {

	Connection con;
	PreparedStatement ps;
	int flag;

	@Override
	public boolean add_food(Food f) {
		con = Dbutility.getcon();
		String string = "insert into food_ct021(food_name,food_type,food_cost) values (?,?,?)";
		try {
			ps = con.prepareStatement(string);
			ps.setString(1, f.getFood_name());
			ps.setString(2, f.getFood_type());
			ps.setInt(3, f.getFood_cost());

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
	public boolean edit(Food f) {
		con = Dbutility.getcon();
		String str1 = "UPDATE `food_ct021` SET `food_name`=?,`food_cost`=?,`food_type`=? where `food_id`=?";
		try {
			ps = con.prepareStatement(str1);
			ps.setString(1, f.getFood_name());
			ps.setInt(2, f.getFood_cost());
			ps.setString(3, f.getFood_type());
			ps.setInt(4, f.getFood_id());

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
	public boolean deletefoodname(String e) {
		con = Dbutility.getcon();
		String str2 = "DELETE FROM `food_ct021` WHERE food_name=?";
		try {
			ps = con.prepareStatement(str2);
			ps.setString(1, e);
			flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByid(int id) {

		con = Dbutility.getcon();
		String str3 = "delete from food_ct021 where food_id=?";
		try {
			ps = con.prepareStatement(str3);
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
	public boolean deleteAll() {
		con = Dbutility.getcon();
		String str4 = "truncate food_ct021";
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
	public Food SearchByid(int id) {
		Food f = new Food();
		con = Dbutility.getcon();
		String str5 = "select * from food_ct021 where food_id=?";
		try {
			ps = con.prepareStatement(str5);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f.setFood_id(rs.getInt(1));
				f.setFood_name(rs.getString(2));
				f.setFood_cost(rs.getInt(3));
				f.setFood_type(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Food> SearchByname(String e) {
		List<Food> lis = new ArrayList<>();

		Connection con = Dbutility.getcon();
		String str5 = "select * from food_ct021 where food_name like ?";
		try {
			PreparedStatement ps = con.prepareStatement(str5);
			ps.setString(1, "%" + e + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Food f = new Food();
				f.setFood_id(rs.getInt(1));
				f.setFood_name(rs.getString(2));
				f.setFood_cost(rs.getInt(3));
				f.setFood_type(rs.getString(4));
				lis.add(f);
			}
			return lis;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Food> SearchBytype(String t) {
		List<Food> list = new ArrayList<>();
		con = Dbutility.getcon();
		String str6 = "select * from food_ct021 where food_type = ?";
		try {
			ps = con.prepareStatement(str6);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Food f = new Food();
				f.setFood_id(rs.getInt(1));
				f.setFood_name(rs.getString(2));
				f.setFood_cost(rs.getInt(3));
				f.setFood_type(rs.getString(4));
				list.add(f);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> ShowAll() {
		List<Food> li = new ArrayList<>();

		con = Dbutility.getcon();
		String s7="select * from food_ct021";
		try {
			ps = con.prepareStatement(s7);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Food f1 = new Food();
				f1.setFood_id(rs.getInt(1));
				f1.setFood_name(rs.getString(2));
				f1.setFood_cost(rs.getInt(3));
				f1.setFood_type(rs.getString(4));
				li.add(f1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

}
