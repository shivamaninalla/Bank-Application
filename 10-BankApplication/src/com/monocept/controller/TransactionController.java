package com.monocept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


import com.monocept.dao.CustomerDbUtil;
import com.monocept.dao.TransactionDbUtil;
import com.monocept.model.Customer;
import com.monocept.model.Transaction;



@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	private TransactionDbUtil transactionDbUtil;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		transactionDbUtil = new TransactionDbUtil(dataSource);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Transaction> transactionList;
		
        HttpSession session = request.getSession();
        String email=(String) session.getAttribute("emailId");
        System.out.println(email);
		
		try {
			
			transactionList = transactionDbUtil.getTransactions(email);
			System.out.println(transactionList);
			request.setAttribute("data", transactionList);
			RequestDispatcher req = request.getRequestDispatcher("passbook.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//list(request, response);
//
//		String command;
//		command = request.getParameter("command");
//		if (command == null) {
//			command = "list";
//		}
//		switch (command) {
//
//		case "newTransaction":
//			try {
//				newTransaction(request, response);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//			
//		case "editProfile":
//			try {
//				editProfile(request, response);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//
//		default:
//			list(request, response);
//			break;
//		}

	}

	private void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        
		String email=(String) session.getAttribute("emailId");
		String f_name=request.getParameter("first_name");
		String l_name=request.getParameter("last_name");
		String pass=request.getParameter("password");
		Customer customer = new Customer(email,f_name,l_name,pass);
		boolean isUpdate= transactionDbUtil.editProfile(customer);
		if(isUpdate) {
			System.out.println("updated");
		}
		else {
			System.out.println("no update");
		}
		
		RequestDispatcher req = request.getRequestDispatcher("edit-profile.jsp");
		req.forward(request, response);
	}
	private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
        HttpSession session = request.getSession();
        
		String email=(String) session.getAttribute("emailId");
		int receiver_account_number = Integer.parseInt(request.getParameter("receiver_account_number"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		transactionDbUtil.newTransaction(email,receiver_account_number,amount);
		
		RequestDispatcher req = request.getRequestDispatcher("new-transaction.jsp");
		req.forward(request, response);

		
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
