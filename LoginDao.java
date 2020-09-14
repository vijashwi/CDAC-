package src.com.in.squad.khanakhaza.dao;
public interface LoginDao {

	boolean Login(String username,String password,String TypeOfCustomer);
	boolean ChangePassword(String username,String newpassword,String oldpassword,String tou);
	boolean ForgetPassword(String username,String tou,String newpassword,String secuirtyques);
	boolean check(String username,String tou,String secuirtyques);
}
