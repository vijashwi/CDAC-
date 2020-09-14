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

import src.com.in.squad.khanakhaza.dao.CustDao;
import src.com.in.squad.khanakhaza.dao.CustDaoImpl;
import src.com.in.squad.khanakhaza.pojo.Customer;

/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustDao cd = new CustDaoImpl();
	Customer c = new Customer();
	boolean flag;
	List<Customer> li = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("allcustlist")) {
			li = cd.ShowAll();
			if (li != null) {
				request.setAttribute("allcustlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("deletecust")) {

			int cid = Integer.parseInt(request.getParameter("cid"));

			flag = cd.delete(cid);
			if (flag) {

				RequestDispatcher rd = request.getRequestDispatcher("CommonCustomerServlet?action=allcustlist");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CommonCustomerServlet?action=allcustlist");
				rd.forward(request, response);
			}
		}
		else if(action!=null && action.equalsIgnoreCase("searchcust")){
			
			String name=request.getParameter("custname");
			li=cd.Searchbyname(name);
			if(li!=null){
				request.setAttribute("allcustlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("SearchCustomer.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("SearchCustomer.jsp");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("allcustlist")) {
			li = cd.ShowAll();
			if (li != null) {
				request.setAttribute("allcustlist", li);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request, response);
			}
		}
		else if (action != null && action.equalsIgnoreCase("addcust")) {

			String cust_name = request.getParameter("cust_name");
			String cust_email = request.getParameter("cust_email");
			String cust_add = request.getParameter("cust_add");
			String cust_mobileno = request.getParameter("cust_mobileno");
			String pass = request.getParameter("cust_password");

			c.setCust_add(cust_add);
			c.setCust_email(cust_email);
			c.setMobile_num(cust_mobileno);
			c.setCust_name(cust_name);
			c.setCust_password(pass);
			flag = cd.cust_add(c);
			if (flag) {
				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("updatecust")) {

			int cid=Integer.parseInt(request.getParameter("cust_id"));
			String cust_add = request.getParameter("cust_add");
			String cust_name = request.getParameter("cust_name");
			String cust_mobileno = request.getParameter("cust_mobileno");
			
			c.setCust_name(cust_name);
			c.setCust_add(cust_add);
			c.setMobile_num(cust_mobileno);
			c.setCust_id(cid);
			flag = cd.cust_edit(c);
			if(flag){
				RequestDispatcher rd = request.getRequestDispatcher("CommonCustomerServlet?action=allcustlist");
				rd.forward(request, response);
			}else{
				
			}
		}
	}

}
