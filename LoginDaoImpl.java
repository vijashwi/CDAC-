package src.com.in.squad.khanakhaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.com.in.squad.khanakhaza.dbutil.Dbutility;
import src.com.in.squad.khanakhaza.pojo.Customer;


public class LoginDaoImpl implements LoginDao {

	Connection con;
	PreparedStatement ps;
	// boolean login;

	Customer c = new Customer();
	boolean flag;
	@Override
	public boolean Login(String username, String password, String TypeOfCustomer) {
		con = Dbutility.getcon();
		
		if (TypeOfCustomer.equalsIgnoreCase("admin")) {
			String str = "select * from adminlogin_ct021 where username=? and password=?";
			try {
				ps = con.prepareStatement(str);
				ps.setString(1, username);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					flag = true;
					return flag;
				} else {

					flag = false;

					return flag;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			String str = "select * from  customer_ct021 where cust_email=? and cust_password=?";
			try {
				ps = con.prepareStatement(str);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					flag = true;
					return flag;
				} else {
					flag = false;

					return flag;

				}
			} catch (SQLException e) {

				e.printStackTrace();

			}

		}
		return flag;

	}

	@Override
	public boolean ChangePassword(String username, String newpassword, String oldpassword, String tou) {
		con = Dbutility.getcon();
		if (tou.equalsIgnoreCase("admin")) {

			String str1 = "update adminlogin_ct021 set password=? where username=? AND password=?";

			try {
				ps = con.prepareStatement(str1);

				ps.setString(1, newpassword);
				ps.setString(2, username);
				ps.setString(3, oldpassword);
				int rs = ps.executeUpdate();
				System.out.println(rs);
				if (rs > 0) {

					return true;
				} else {

					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		} else {
			String str2 = "update customer_ct021 set cust_password=? where cust_email=? AND cust_password=?";
			try {
				ps = con.prepareStatement(str2);
				ps.setString(1, newpassword);
				ps.setString(2, username);
				ps.setString(3, oldpassword);
				int rs = ps.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean ForgetPassword(String username, String tou, String newpassword, String secuirtyques) {
		con = Dbutility.getcon();
		if (tou.equalsIgnoreCase("admin")) {
			String str2 = "update adminlogin_ct021 set password=? where security_Ques=?";
			try {
				ps = con.prepareStatement(str2);
				ps.setString(1, newpassword);
				ps.setString(2, secuirtyques);
				int rs = ps.executeUpdate();

				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean check(String username, String tou, String secuirtyques) {
		con = Dbutility.getcon();
		String str = "select * from adminlogin_ct021 where username=? and security_Ques=? ";
		try {
			ps = con.prepareStatement(str);
			ps.setString(1, username);
			ps.setString(2, secuirtyques);
			// ps.setString(3, tou);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
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
}
