package src.com.in.squad.khanahaza.test;

import java.util.Scanner;

import src.com.in.squad.khanakhaza.dao.LoginDao;
import src.com.in.squad.khanakhaza.dao.LoginDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Login;

public class LoginTest {

	public static void main(String[] args) {
		Login l = new Login();
		LoginDao ld = new LoginDaoImpl();

		String username;
		String TypeOfCustomer;
		String password = null;
		String oldpassword;
		String newpassword;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		boolean flag;
		do {
			System.out.println("====================================");
			System.out.println("***********KHANAKHAZA***************");
			System.out.println("====================================");
			System.out.println(
					"\n Enter your choice \n " + "\n1.Login :" + "\n2.Change Password :" + "\n3.Forget Password :");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter username");
				username = l.setUsername(sc.next());
				System.out.println("Enter Password");
				password = l.setPassword(sc.next());
				System.out.println("Enter type of user");
				TypeOfCustomer = l.setTypeOfCustomer(sc.next());
				flag = ld.Login(username, password, TypeOfCustomer);
				if (flag)
					System.out.println("LOGIN SUCESFULL");
				else
					System.out.println("LOGIN FAILED");
				break;
			case 2:
				System.out.println("Enter username");
				username = sc.next();
				System.out.println("Enter new Password");
				newpassword = sc.next();
				System.out.println("Enter old Password");
				oldpassword = sc.next();
				System.out.println("Enter Type of user");
				String tou = sc.next();
				flag = ld.ChangePassword(username, newpassword, oldpassword, tou);
				if (flag) {
					System.out.println("Password changed sucesfully");
				} else {
					System.out.println("FAiled to change password");
				}
				break;
				
			case 3:
				System.out.println("Enter Username");
				username=sc.next();
				System.out.println("Enter Type of user");
				tou=sc.next();
				System.out.println("Enter Secuirty Question");
				String secuirtyques=sc.next();
				
				flag=ld.check(username, tou, secuirtyques);
				if(flag){
					System.out.println("Enter New Password");
					newpassword=sc.next();
					flag=ld.ForgetPassword(username, tou, newpassword, secuirtyques);
					if(flag)
						System.out.println("Password Change Sucessful");
					else
						System.out.println("FAILED");
				}
				else{
					System.out.println("INVALID");
				}
				
				break;
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Do you want to continue....");
			choice = sc.nextInt();
		} while (choice != 0);
	}
}
