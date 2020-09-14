package src.com.in.squad.khanahaza.test;

import java.util.List;
import java.util.Scanner;

import src.com.in.squad.khanakhaza.dao.FoodDao;
import src.com.in.squad.khanakhaza.dao.FoodDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Food;


public class FoodTest {
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Food f=new Food();
		FoodDao fd=new FoodDaoImpl();
		boolean flag;
		int choice=0;
		do {
			System.out.println("====================================");
			System.out.println("***********KHANAKHAZA***************");
			System.out.println("====================================");
			System.out.println("\nEnter Your choice \n"+"\n1.ADD FOOD :"+"\n2.EDIT/UPDATE FOOD :"+"\n3.DELETE FOOD BY NAME :"
			+"\n4.DELETE FOOD BY ID :"+"\n5.DELETE ALL :" +"\n6.SHOW ALL :"+"\n7.SEARCH BY ID :"+"\n8.SEARCH BY NAME :"+"\n9.SEARCH BY TYPE :"+"\n10.EXIT :");

			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter Food name");
				f.setFood_name(sc.next());
				System.out.println("Enter Food Cost");
				f.setFood_cost(sc.nextInt());
				System.out.println("Enter Food Type");
				f.setFood_type(sc.next());
				flag=fd.add_food(f);
				if(flag)
					System.out.println("Food Added To Cart");
				else
					System.out.println("*****FAILED*****");
				break;
				
			case 2:
				System.out.println("ENter Food id");
				f.setFood_id(sc.nextInt());
				System.out.println("Enter Food name");
				f.setFood_name(sc.next());
				System.out.println("Enter Food Cost");
				f.setFood_cost(sc.nextInt());
				System.out.println("Enter Food Type");
				f.setFood_type(sc.next());
				flag=fd.edit(f);
				if(flag)
					System.out.println("*****RECORD UPDATED*****");
				else
					System.out.println("*****FAILED******");
				break;
			case 3:
				System.out.println("Enter Food name");
				flag=fd.deletefoodname(sc.next());
				if(flag)
					System.out.println("Record Deleted");
				else
					System.out.println("*****FAILED******");
				break;
			case 4:
				System.out.println("ENter Food id");
				//f.setFood_id(sc.nextInt());
				flag=fd.deleteByid(sc.nextInt());
				if(flag)
					System.out.println("Record Deleted");
				else
					System.out.println("*****FAILED******");
				break;
			case 5:
				flag=fd.deleteAll();
				if(flag)
					System.out.println("All Record Deleted");
				else
					System.out.println("*****FAILED******");
				break;
			case 6:
				List<Food> list=fd.ShowAll();
				if(list.isEmpty())
					System.out.println("*****NOTHING FOUND*****");
				for(Food ff:list)
					System.out.println(ff);
				break;
			case 7:
				System.out.println("Enter Food id");
				Food flag1=fd.SearchByid(sc.nextInt());
				if(flag1!=null)
					System.out.println(flag1);
				else
					System.out.println("*****NOTHING FOUND*****");
				break;
			case 8:
				System.out.println("Enter Food name");
				List<Food> li=fd.SearchByname(sc.next());
				if(li.isEmpty())
					System.out.println("*****NOTHING FOUND*****");
				for(Food f1:li)
					System.out.println(f1);
				break;
			case 9:
				System.out.println("Enter Food type");
				List<Food> lis=fd.SearchBytype(sc.next());
				if(lis.isEmpty())
					System.out.println("*****NOTHING FOUND*****");
				for(Food f1:lis)
					System.out.println(f1);
				break;
			case 10:
				System.exit(0); 
				break;
				default:
					System.out.println("Wrong Choice Entered");
			}
			System.out.println("Do you want to continue");
			choice=sc.nextInt();
		}while(choice!=0);
		}

	}

