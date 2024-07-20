package com.monocept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("Welcome Admin");
//		out.println("<br>");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("admin-home.jsp");
	        dispatcher.forward(request, response);

	//	out.println("<a href=\"logout\">Logout</a>");
	}
}