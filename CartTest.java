package src.com.in.squad.khanahaza.test;

import java.util.List;
import java.util.Scanner;

import src.com.in.squad.khanakhaza.dao.CartDao;
import src.com.in.squad.khanakhaza.dao.CartDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Cart;


public class CartTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Cart c=new Cart();
		CartDao cd=new CartDaoImpl();
		boolean flag;
		int choice=0;
		do {
			System.out.println("====================================");
			System.out.println("***********KHANAKHAZA***************");
			System.out.println("====================================");
			System.out.println("\n Enter your choice \n "+"\n1.ADD CART :"+"\n2.VIEW ALL :"+"\n3.SEARCH BY EMAIL :"+"\n4.DELETE BY EMAIL :"+"\n5.DELETE ALL :"+"\n6.Show All"+"\n7.DeleteByID"+"\n8.Exit");
			int ch=sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter Customer email");
				c.setCust_email(sc.next());
				System.out.println("Enter Food id");
				c.setFood_id(sc.nextInt());
				System.out.println("Enter Quantity of food");
				c.setFood_qty(sc.nextInt());
				flag=cd.add_cart(c);
				if(flag)
					System.out.println("CART ADDED SUCESSFULLY");
				else
					System.out.println("****FAILED*****");
				break;
			case 2:
				List<Cart>li=cd.ViewAll();
				if(li.isEmpty())
					System.out.println("***NOTHING FOUND***");
				for(Cart cc:li)
					System.out.println(cc);
				break;
			case 3:
				System.out.println("Enter Customer email");
				List<Cart> lis=cd.SearchByEmail(sc.next());
				if(lis.isEmpty())
					System.out.println("***NOTHING FOUND***");
				for(Cart c1:lis)
					System.out.println(c1);
				break;
				case 4:
					System.out.println("Enter Customer email");
					flag=cd.DeleteByEmail(sc.next());
					if(flag)
						System.out.println("RECORD DELETED");
					else
						System.out.println("**FAILED***");
					break;
				case 5:
					flag=cd.DeleteAll();
					if(flag)
						System.out.println("***FAILED***");
					else
						System.out.println("ALL RECORD DELETED");
					break;
					case 6:
						List<Cart> fli=cd.ShowAll();
						if(fli.isEmpty())
							System.out.println("NOTTHING FOUND");
						for(Cart cc:fli)
							System.out.println(cc);
						break;
					case 7:
						System.out.println("Enter Cart id to delete");
						flag=cd.DeleteById(sc.nextInt());
						if(flag)
							System.out.println("Cart Deleted");
						else
							System.out.println("Failed");
						break;
					case 8:
						System.out.println("Ener cart id");
						c.setCart_id(sc.nextInt());
						System.out.println("Enter Food quantity");
						c.setFood_qty(sc.nextInt());
						flag=cd.updatecart(c);
						if(flag)
							System.out.println("Updated Sucessfully");
						else
							System.out.println("Failed");
						break;
			default:
				System.out.println("Wrong choice Entered");
			}
			System.out.println("Do you Want to continue..");
			choice=sc.nextInt();
		}while(choice!=0);
	}
}
