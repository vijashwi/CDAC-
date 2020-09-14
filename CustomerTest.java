package src.com.in.squad.khanahaza.test;



import org.eclipse.jdt.internal.compiler.parser.Scanner;

import src.com.in.squad.khanakhaza.dao.CustDao;
import src.com.in.squad.khanakhaza.dao.CustDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Customer cust=new Customer();
	CustDao cd=new CustDaoImpl();
	int choice=0;
	boolean flag;
	do {
		System.out.println("====================================");
		System.out.println("***********KHANAKHAZA***************");
		System.out.println("====================================");
		System.out.println("\nEnter Your choice \n"+"\n1.ADD CUSTOMER :"+"\n2.EDIT/UPDATE CUSTOMER :"+"\n3.DELETE CUSTOMER :"
		+"\n4.SHOW ALL :"+"\n5.SEARCH BY ID :" +"\n6.SEARCH BY NAME :"+"\n7.DELETE ALL :"+"\n8.SEARCH BY KEYWORD :"+"\n9.Exit");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter Customer name");
			cust.setCust_name(sc.next());
			System.out.println("Enter Customer email");
			cust.setCust_email(sc.next());
			System.out.println("Enter Customer address");
			cust.setCust_add(sc.next());
			System.out.println("Enter Contact number");
			cust.setMobile_num(sc.next());
			System.out.println("Enter password");
			cust.setCust_password(sc.next());
			flag=cd.cust_add(cust);
			if(flag)
				System.out.println("Record Added Sucesffully");
			else
				System.out.println("****FAILED****");
			break;
			
		case 2:
			System.out.println("Enter Customer id");
			cust.setCust_id(sc.nextInt());
			System.out.println("Enter Customer name");
			cust.setCust_name(sc.next());
			System.out.println("Enter Customer address");
			cust.setCust_add(sc.next());
			System.out.println("Enter Contact number");
			cust.setMobile_num(sc.next());
			flag=cd.cust_edit(cust);
			if(flag)
				System.out.println("Information Updated");
			else
				System.out.println("****FAILED*****");
			break;
		case 3:
			System.out.println("Enter Customer id");
			//cust.setCust_id(sc.nextInt());
			flag=cd.delete(sc.nextInt());
			if(flag)
				System.out.println("Record Sucessfully Deleted");
			else
				System.out.println("****FAILED*****");
			break;
		case 4:
			List<Customer> li=cd.ShowAll();;
			if(li.isEmpty())
				System.out.println("****NOTHING FOUND****");
			for(Customer c:li)
				System.out.println(c);
			break;
		case 5:
			System.out.println("Enter Customer id");
			Customer flag1=cd.Searchbyid(sc.nextInt());
			if(flag1!=null)
				System.out.println(flag1);
			else
				System.out.println("****NOTHING FOUND*****");
			break;
		case 6:
			System.out.println("Enter Customer Name");
			List<Customer> lis=cd.Searchbyname(sc.next());
			if(lis.isEmpty())
				System.out.println("****NOTHING FOUND******");
			for(Customer c2:lis)
				System.out.println(c2);
			break;
		case 7:
			flag=cd.deleteall();
			if(flag)
				System.out.println("***FAILED****");
			else
			System.out.println("ALL DELETED");
			break;
		case 8:
			System.out.println("Enter Customer name");
			List<Customer> list=cd.Searchbykeyword(sc.next());
			if(list.isEmpty())
				System.out.println("****NOTHING FOUND****");
			for(Customer cc:list)
				System.out.println(cc);
			break;
		case 9:
			System.exit(0); 
			break;
			default:
				System.out.println("WRONG CHOICE ENTERED");
		}
		System.out.println("Do you want to continue");
		choice=sc.nextInt();
	}while(choice!=0);
	}

}
