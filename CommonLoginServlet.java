package com.in.squad.khanakhaza;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.in.squad.khanakhaza.dao.LoginDao;
import src.com.in.squad.khanakhaza.dao.LoginDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Login;

@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao ld = new LoginDaoImpl();
	Login l = new Login();
	boolean flag;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("loggedout", "logged out");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		System.out.println(action);
		if (action != null && action.equalsIgnoreCase("login")) {

			String uname = request.getParameter("username");
			String pass = request.getParameter("password");
			String type = request.getParameter("type");

			flag = ld.Login(uname, pass, type);

			if (flag) {

				session.setAttribute("username", uname);
				session.setAttribute("login_type", type);

				if (type.equalsIgnoreCase("admin")) {

					request.setAttribute("Adminloggedinsucessfull", "Admin Logged In Sucessfully  :" + uname);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} else {

					request.setAttribute("Customerloggedinsucessfull", "Customer Logged In Sucessfully  :" + uname);

					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} else {
				response.sendRedirect("Fail.jsp");
			}

		} 
	}
}