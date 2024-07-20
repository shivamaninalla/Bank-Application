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

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TransactionDbUtil transactionDbUtil;
	private CustomerDbUtil customerDbUtil;
	@Resource(name = "jdbc/bank_application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		transactionDbUtil = new TransactionDbUtil(dataSource);
		customerDbUtil = new CustomerDbUtil(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("UserController");
		System.out.println(command);

		if (command == null) {
			command = "customer-home";
		}

		switch (command) {

		case "Pass Book":
			// forwardToTransactionController(request, response, "list");
			// passbook(request, response,"list");
			list(request, response);
			break;

		case "New Transaction":
			// forwardToTransactionController(request, response, "newTransaction");
			System.out.println("Hi nana");
			try {
				newTransaction2(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Edit Profile":
			System.out.println("hhhhhhhhhh");
			try {
				editProfile2(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "newTransaction":
			try {
				newTransaction(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "editProfile":
			System.out.println("gnhlkdrnhdnh");
			try {
				editProfile(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			customerHome(request, response);
		}

	}

	private void customerHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside customer Home doGet method");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cust-home.jsp");
		requestDispatcher.forward(request, response);

	}

//	private void passbook(HttpServletRequest request, HttpServletResponse response, String list)
//			throws ServletException, IOException {
//		System.out.println("Inside passbook");
//		request.setAttribute("method", list);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TransactionController");
//        requestDispatcher.forward(request, response);
//		
////		RequestDispatcher requestDispatcher = request.getRequestDispatcher("passbook.jsp");
////		requestDispatcher.forward(request, response);
//
//	}

//	private void newTransaction(HttpServletRequest request, HttpServletResponse response, String newTransaction)
//			throws ServletException, IOException {
//		System.out.println("Inside New Transaction doGet method");
//		request.setAttribute("method", newTransaction);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TransactionController");
//        requestDispatcher.forward(request, response);
////		RequestDispatcher requestDispatcher = request.getRequestDispatcher("new-transaction.jsp");
////		requestDispatcher.forward(request, response);
//	}

//	private void editProfile(HttpServletRequest request, HttpServletResponse response, String editProfile)
//			throws ServletException, IOException {
//		System.out.println("Inside EditProfile doGet method");
//		request.setAttribute("method", editProfile);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TransactionController");
//        requestDispatcher.forward(request, response);
////		RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-profile.jsp");
////		requestDispatcher.forward(request, response);
//	}

//	private void forwardToTransactionController(HttpServletRequest request, HttpServletResponse response, String method)
//            throws ServletException, IOException {
//        request.setAttribute("method", method);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TransactionController");
//        requestDispatcher.forward(request, response);
//    }

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Transaction> transactionList;

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailId");
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

	private void editProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("emailId");
		System.out.println("Emial"+email);
		String f_name = request.getParameter("first_name");
		String l_name = request.getParameter("last_name");
		String pass = request.getParameter("password");
		Customer customer = new Customer(email, f_name, l_name, pass);
		boolean isUpdate = transactionDbUtil.editProfile(customer);
		if (isUpdate) {
			System.out.println("updated");
		} else {
			System.out.println("no update");
		}

		response.sendRedirect(request.getContextPath()+"/user");
	}
	
	private void editProfile2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		RequestDispatcher req = request.getRequestDispatcher("edit-profile.jsp");
		req.forward(request, response);

	}

	private void newTransaction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println("new transaction");

		String email = (String) session.getAttribute("emailId");
		int receiver_account_number = Integer.parseInt(request.getParameter("receiver_account_number"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		transactionDbUtil.newTransaction(email, receiver_account_number, amount);

		response.sendRedirect(request.getContextPath()+"/user");

	}
	private void newTransaction2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		

		RequestDispatcher req = request.getRequestDispatcher("new-transaction.jsp");
		req.forward(request, response);

	}

}
