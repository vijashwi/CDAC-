package com.in.squad.khanakhaza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.in.squad.khanakhaza.dao.FoodDao;
import src.com.in.squad.khanakhaza.dao.FoodDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Food;

/**
 * Servlet implementation class CommonFoodServlet
 */
@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FoodDao fd = new FoodDaoImpl();
	Food food = new Food();
	List<Food> fli = new ArrayList<>();
	boolean flag;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if (action != null && action.equalsIgnoreCase("foodlist")) {

			fli=fd.ShowAll();
			if (fli != null) {
				
				request.setAttribute("foodlist", fli);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("Fail.jsp");
			}
		}
		else if(action!=null && action.equalsIgnoreCase("deletefood")){
			
			int fid=Integer.parseInt(request.getParameter("fid"));
			
			flag=fd.deleteByid(fid);
			if(flag){
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
		}
		else if(action!=null && action.equalsIgnoreCase("searchfood")){
			
			String fname=request.getParameter("fname");
			fli=fd.SearchByname(fname);
			if(fli!=null){
				request.setAttribute("foodlist", fli);
				RequestDispatcher rd = request.getRequestDispatcher("SearchFood.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("SearchFood.jsp");
				rd.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		List<Food> fli = new ArrayList<>();
		if (action != null && action.equalsIgnoreCase("foodlist")) {

			fli=fd.ShowAll();
			if (fli != null) {
				
				request.setAttribute("foodlist", fli);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("Fail.jsp");
			}
		}
		else if(action!=null && action.equalsIgnoreCase("updatefood")){
			
			int fid=Integer.parseInt(request.getParameter("food_id"));
			String fname=request.getParameter("food_name");
			int fcost=Integer.parseInt(request.getParameter("food_cost"));
			String type=request.getParameter("food_category");
			
			food.setFood_id(fid);
			food.setFood_name(fname);
			food.setFood_cost(fcost);
			food.setFood_type(type);
			
			flag=fd.edit(food);
			if(flag){
				
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
			else{

				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
		}


		else if (action != null && action.equalsIgnoreCase("addfood")) {

			String foodname = request.getParameter("food_name");
			String foodcat = request.getParameter("food_category");
			int foodcost = Integer.parseInt(request.getParameter("food_cost"));

			food.setFood_name(foodname);
			food.setFood_cost(foodcost);
			food.setFood_type(foodcat);



			flag = fd.add_food(food);
			if (flag) {
				request.setAttribute("foodlist", fli);
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			} else {
				response.sendRedirect("Fail.jsp");

			}
		}

	}
}
