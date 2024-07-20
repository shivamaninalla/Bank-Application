
package com.monocept.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.monocept.dao.CustomerDbUtil;

@WebServlet("/login")
public class LoginServletBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDbUtil customerDbUtil;

	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		customerDbUtil = new CustomerDbUtil(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("login-email");
		String password = request.getParameter("login-password");
		String userRole = request.getParameter("userRole");

		if (userRole.equals("Admin")) {
			if ("admin@gmail.com".equals(emailId) && "admin123".equals(password)) {
				
				System.out.println( "in admin");
				HttpSession session = request.getSession();
				session.setAttribute("emailId", emailId);
				session.setAttribute("userRole1", "Admin");
				response.sendRedirect("admin");
			}
		} 
		
		else if (customerDbUtil.validateCustomer(emailId, password) && userRole.equals("User")) {
			HttpSession session = request.getSession();
			session.setAttribute("emailId", emailId);
			session.setAttribute("userRole", "User");
			System.out.println("in customer");
			response.sendRedirect("user");
			
		}

		else {
			System.out.println( "in else");
			response.sendRedirect("login.jsp?error=true");
		}
	}
}
