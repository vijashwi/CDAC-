package src.com.in.squad.khanakhaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.in.squad.khanakhaza.dbutil.Dbutility;
import src.com.in.squad.khanakhaza.pojo.Customer;


public class CustDaoImpl implements CustDao {

	int flag;

	@Override
	public boolean cust_add(Customer cust) {

		Connection con = Dbutility.getcon();
		String str = "INSERT INTO `customer_ct021`(`cust_name`, `cust_email`, `cust_add`, `cust_password`, `cust_mobile_num`) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, cust.getCust_name());
			ps.setString(2, cust.getCust_email());
			ps.setString(3, cust.getCust_add());
			ps.setString(5, cust.getMobile_num());
			ps.setString(4, cust.getCust_password());

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
	public boolean cust_edit(Customer cust) {
		Connection con=Dbutility.getcon();
		
		String str1="UPDATE `customer_ct021` SET `cust_name`=?,`cust_add`=?,`cust_mobile_num`=? WHERE cust_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(str1);
		
			ps.setString(1,cust.getCust_name());
			ps.setString(2,cust.getCust_add());
			ps.setString(3,cust.getMobile_num());
			ps.setInt(4,cust.getCust_id());
			flag=ps.executeUpdate();
			if(flag>0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection con=Dbutility.getcon();
		String str2="DELETE FROM `customer_ct021` WHERE cust_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(str2);
			ps.setInt(1,id);
			
			flag=ps.executeUpdate();
			
			if(flag>0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> ShowAll() {
		
		List<Customer> li=new ArrayList<>();
		
		Connection con=Dbutility.getcon();
		
		String str3="select * from customer_ct021";
		try {
			PreparedStatement ps=con.prepareStatement(str3);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer cust1=new Customer();
				cust1.setCust_id(rs.getInt(1));
				cust1.setCust_name(rs.getString(2));
				cust1.setCust_email(rs.getString(3));
				cust1.setCust_add(rs.getString(4));
				cust1.setCust_password(rs.getString(5));
				cust1.setMobile_num(rs.getString(6));
				
			li.add(cust1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Customer Searchbyid(int id) {
		Customer cust1=new Customer();
		Connection con=Dbutility.getcon();
		String str4="select * from customer_ct021 where cust_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(str4);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cust1.setCust_id(rs.getInt(1));
				cust1.setCust_name(rs.getString(2));
				cust1.setCust_email(rs.getString(3));
				cust1.setCust_add(rs.getString(4));
				cust1.setCust_password(rs.getString(5));
				cust1.setMobile_num(rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust1;
	}
	
	public Customer SearchbyEmail(String email) {
		Customer cust1=new Customer();
		Connection con=Dbutility.getcon();
		String str4="select * from customer_ct021 where cust_email=?";
		try {
			PreparedStatement ps=con.prepareStatement(str4);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cust1.setCust_id(rs.getInt(1));
				cust1.setCust_name(rs.getString(2));
				cust1.setCust_email(rs.getString(3));
				cust1.setCust_add(rs.getString(4));
				cust1.setCust_password(rs.getString(5));
				cust1.setMobile_num(rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust1;
	}

	@Override
	public List<Customer> Searchbyname(String e) {
		List<Customer> lis=new ArrayList<>();
		
		Connection con=Dbutility.getcon();
		String str5="select * from customer_ct021 where cust_name like ?";
		try {
			PreparedStatement ps=con.prepareStatement(str5);
			ps.setString(1,"%"+e+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer cust2=new Customer();
				cust2.setCust_name(rs.getString(2));
				cust2.setCust_email(rs.getString(3));
				cust2.setCust_add(rs.getString(4));
				cust2.setCust_password(rs.getString(5));
				cust2.setMobile_num(rs.getString(6));
				lis.add(cust2);
			}
			return lis;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deleteall() {
		Connection con=Dbutility.getcon();
		String str6="truncate customer_ct021";
		try {
			PreparedStatement ps=con.prepareStatement(str6);
			flag=ps.executeUpdate();
			if(flag>0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> Searchbykeyword(String e) {
		List<Customer> list=new ArrayList<>();
		Connection con=Dbutility.getcon();
		
		String str7="select * from customer_ct021 where cust_name = ?";
		try {
			PreparedStatement ps=con.prepareStatement(str7);
			ps.setString(1,e);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer cust=new Customer();
				cust.setCust_id(rs.getInt(1));
				cust.setCust_name(rs.getString(2));
				cust.setCust_email(rs.getString(3));
				cust.setCust_add(rs.getString(4));
				cust.setCust_password(rs.getString(5));
				cust.setMobile_num(rs.getString(6));
				list.add(cust);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

}
