package src.com.in.squad.khanahaza.test;

import java.util.List;
import java.util.Scanner;

import src.com.in.squad.khanakhaza.dao.OrdersDao;
import src.com.in.squad.khanakhaza.dao.OrdersDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Orders;

public class OrdersTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Orders o=new Orders();
		OrdersDao od=new OrdersDaoImpl();
		boolean flag;
		int choice=0;
		do {
			System.out.println("==============================");
			System.out.println("*******KHANAKHAZA*************");
			System.out.println("==============================");
			System.out.println("\n Enter Your choice :"+"\n1.Place Order :"+"\n2.View All :"+"\n3.Search By Email :"+"\n4.Delete By Email :"+"\n5.Delete All :");
			System.out.println("Do you want to continue");
			int ch=sc.nextInt();
			switch(ch) {
			
			case 1:
				System.out.println("Enter Customer email");
				flag=od.PlaceOrder(sc.next());
				if(flag)
					System.out.println("ORDER PLACED");
				else
					System.out.println("**FAILED****");
				break;
			case 2:
				List<Orders> li=od.ViewAll();
				if(li.isEmpty())
					System.out.println("****NO ORDERS PLACED****");
				for(Orders ooo:li)
					System.out.println(ooo);
				break;
			case 3:
				System.out.println("Enter Customer Email");
				List<Orders> lis=od.SearchByEmail(sc.next());
				if(lis.isEmpty())
					System.out.println("***NO RECORD FOUND***");
				for(Orders oo1:lis)
					System.out.println(oo1);
				break;
			case 4:
				System.out.println("Enter Customer Email");
				flag=od.DeleteById(sc.nextInt());
				if(flag)
					System.out.println("ORDER DELETED");
				else
					System.out.println("****FAILED****");
				break;
				case 5:
					flag=od.DeleteAll();
					if(flag)
						System.out.println("*FAILED*");
					else
						System.out.println("ALL RECORDS DELETED");
					break;
					default:
						System.out.println("====WRONG CHOICE====");
			}
			choice=sc.nextInt();
		}while(choice!=0);

	}

}
