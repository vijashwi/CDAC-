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
import javax.servlet.http.HttpSession;

import src.com.in.squad.khanakhaza.dao.CartDao;
import src.com.in.squad.khanakhaza.dao.CartDaoImpl;
import src.com.in.squad.khanakhaza.dao.OrdersDao;
import src.com.in.squad.khanakhaza.dao.OrdersDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Orders;

/**
 * Servlet implementation class CommonOrderServlet
 */
@WebServlet("/CommonOrderServlet")
public class CommonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrdersDao od = new OrdersDaoImpl();
	Orders o = new Orders();
	List<Orders> fli = new ArrayList<>();
	boolean flag;
	CartDao cd = new CartDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action != null && action.equalsIgnoreCase("allorders")) {

			fli = od.ViewAll();
			if (fli != null) {
				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("placeorder")) {

			String email = (String) session.getAttribute("username");
			flag = od.PlaceOrder(email);
			if (flag) {
				
				cd.DeleteByEmail(email);
				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			}

		}

		else if (action != null && action.equalsIgnoreCase("myorder")) {
			String email = (String) session.getAttribute("username");
			fli = od.SearchByEmail(email);
			if (fli != null) {
				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			}
		}

		else if (action != null && action.equalsIgnoreCase("deleteorder")) {
			int oid =Integer.parseInt(request.getParameter("oid")); 

					flag = od.DeleteById(oid);
			if (flag) {

				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			}
		}
		else if (action != null && action.equalsIgnoreCase("deleteall")) {
			
					flag = od.DeleteAll();
			if (flag) {
				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CommonOrderServlet?action=myorder");
				rd.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("placeorder")) {

			String email = (String) session.getAttribute("username");
			flag = od.PlaceOrder(email);
			if (flag) {
				request.setAttribute("allorders", fli);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}

		}
	}
}
