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
import javax.websocket.Session;

import com.sun.net.httpserver.Authenticator.Success;

import src.com.in.squad.khanakhaza.dao.CartDao;
import src.com.in.squad.khanakhaza.dao.CartDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Cart;

/**
 * Servlet implementation class CommonCartServlet
 */
@WebServlet("/CommonCartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CartDao cd = new CartDaoImpl();
	Cart c = new Cart();
	List<Cart> li = new ArrayList<>();
	boolean flag;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		System.out.println(action);
		if (action != null && action.equalsIgnoreCase("allcartlist")) {

			li = cd.ViewAll();
			if (li != null) {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		}

		else if (action != null && action.equalsIgnoreCase("customercartlist")) {
			String email = (String) session.getAttribute("username");
			List<Cart> li1 = new ArrayList<>();
			li1 = cd.SearchByEmail(email);
			if (li1 != null) {
				request.setAttribute("allcartlist", li1);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			} else {
			
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("deletecart")) {

			int cid = Integer.parseInt(request.getParameter("cid"));
			flag = cd.DeleteById(cid);
			if (flag) {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("deleteall")) {

			flag = cd.DeleteAll();
			if (flag) {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			}
		}

		else if (action != null && action.equalsIgnoreCase("updatecart")) {

			int cid = Integer.parseInt(request.getParameter("cid"));
			int food_qty = Integer.parseInt(request.getParameter("quantity"));
			c.setCart_id(cid);
			c.setFood_qty(food_qty);
			flag = cd.updatecart(c);
			if (flag) {

				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			}
		}
		else if (action != null && action.equalsIgnoreCase("addcart")) {

			int fid = Integer.parseInt(request.getParameter("food_id"));
			String custemail = (String) session.getAttribute("username");
			int quant = 0;

			c.setFood_id(fid);
			c.setCust_email(custemail);
			c.setFood_qty(quant);

			flag = cd.add_cart(c);

			if (flag) {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action != null && action.equalsIgnoreCase("allcartlist")) {

			li = cd.ViewAll();
			if (li != null) {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("customercartlist")) {
			String email = (String) session.getAttribute("username");
			List<Cart> li1 = new ArrayList<>();
			li1 = cd.SearchByEmail(email);
			if (li1 != null) {
				request.setAttribute("allcartlist", li1);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("addcart")) {

			List<Cart> li1 = new ArrayList<>();
			int fid = Integer.parseInt(request.getParameter("food_id"));
			String custemail = (String) session.getAttribute("username");
			int quant = 0;

			c.setFood_id(fid);
			c.setCust_email(custemail);
			c.setFood_qty(quant);

			flag = cd.add_cart(c);

			if (flag) {
				
				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("CommonFoodServlet?action=foodlist");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("updatecart")) {

			int cid = Integer.parseInt(request.getParameter("cid"));
			System.out.println("I am in update cart"+action);
			int food_qty = Integer.parseInt(request.getParameter("quanity"));
			c.setCart_id(cid);
			c.setFood_qty(food_qty);
			flag = cd.updatecart(c);
			if (flag) {

				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			} else {
				request.setAttribute("allcartlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CommonCartServlet?action=customercartlist");
				rd.forward(request, response);
			}
		}

	}

}
