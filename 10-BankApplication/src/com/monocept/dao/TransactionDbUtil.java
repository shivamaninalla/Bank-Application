package com.monocept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.monocept.model.Customer;
import com.monocept.model.Transaction;

public class TransactionDbUtil {
	private DataSource dataSource;

	public TransactionDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Transaction> getTransactions(String email) throws SQLException {

		List<Transaction> transactions = new ArrayList<>();
		Connection conn = dataSource.getConnection();

		String query =

				"SELECT " + "t.sender_account_number, " + "t.receiver_account_number, " + "t.transaction_type, "
						+ "t.transaction_amount, " + "t.date_of_transaction " + "FROM " + "transactions t "
						+ "JOIN accounts a_sender ON t.sender_account_number = a_sender.account_number "
						+ "JOIN accounts a_receiver ON t.receiver_account_number = a_receiver.account_number "
						+ "JOIN customer c_sender ON c_sender.customer_id = a_sender.customer_id "
						+ "JOIN customer c_receiver ON c_receiver.customer_id = a_receiver.customer_id " + "WHERE "
						+ "c_sender.email_id = ? OR c_receiver.email_id = ?";

		PreparedStatement st2 = conn.prepareStatement(query);
		st2.setString(1, email);
		st2.setString(2, email);
		ResultSet rs2 = st2.executeQuery();

		while (rs2.next()) {

			int senderAccountNumber = rs2.getInt("sender_account_number");
			int receiverAccountNumber = rs2.getInt("receiver_account_number");
			String type = rs2.getString("transaction_type");
			double amount = rs2.getDouble("transaction_amount");
			String date = rs2.getString("date_of_transaction");

			Transaction transaction = new Transaction(senderAccountNumber, receiverAccountNumber, type, amount, date);
			transactions.add(transaction);

		}
		return transactions;

	}

	public void newTransaction(String email, int receiver_account_number, int amount) throws SQLException {
		Connection conn = null;
		PreparedStatement st1 = null;
		PreparedStatement st = null;
		PreparedStatement st3 = null;
		PreparedStatement st5 = null;
		PreparedStatement st4 = null;
		ResultSet rs1 = null;
		ResultSet rs = null;
		ResultSet rs5 = null;

		try {
			conn = dataSource.getConnection();

			String query1 = "SELECT a.balance FROM accounts a JOIN customer c ON c.customer_id = a.customer_id WHERE email_id = ?";
			st1 = conn.prepareStatement(query1);
			st1.setString(1, email);
			rs1 = st1.executeQuery();

			if (rs1.next() && rs1.getDouble("balance") > amount) {
				String q = "SELECT balance FROM accounts WHERE account_number = ?";
				st = conn.prepareStatement(q);
				st.setInt(1, receiver_account_number);
				rs = st.executeQuery();

				if (rs.next()) {
					Double receiver_balance = rs.getDouble("balance");

					String query3 = "UPDATE accounts SET balance = ? WHERE account_number = ?";
					st3 = conn.prepareStatement(query3);
					st3.setDouble(1, receiver_balance + amount);
					st3.setInt(2, receiver_account_number);
					st3.executeUpdate();

					String q2 = "SELECT a.account_number FROM accounts a JOIN customer c ON c.customer_id = a.customer_id WHERE email_id = ?";
					st5 = conn.prepareStatement(q2);
					st5.setString(1, email);
					rs5 = st5.executeQuery();
					
					

					if (rs5.next()) {
						String query4 = "UPDATE accounts SET balance = ? WHERE account_number = ?";
						st4 = conn.prepareStatement(query4);
						st4.setDouble(1, rs1.getDouble("balance") - amount);
						st4.setInt(2, rs5.getInt("account_number"));
						st4.executeUpdate();
						
						
						
						String query5="insert into transactions (sender_account_number, receiver_account_number,transaction_type,transaction_amount)values(?,?,?,?)";
						st5 = conn.prepareStatement(query5);
						st5.setInt(1,rs5.getInt("account_number"));
						st5.setInt(2, receiver_account_number);
						st5.setString(3, "Transfer");
						st5.setDouble(4, amount);
						st5.executeUpdate();

					}
				}
			} else {
				System.out.println("Insufficient balance.");
			}
		} finally {
			// Close resources
			if (rs1 != null)
				rs1.close();
			if (rs != null)
				rs.close();
			if (rs5 != null)
				rs5.close();
			if (st1 != null)
				st1.close();
			if (st != null)
				st.close();
			if (st3 != null)
				st3.close();
			if (st5 != null)
				st5.close();
			if (st4 != null)
				st4.close();
			if (conn != null)
				conn.close();
		}
	}

	public boolean editProfile(Customer customer) throws SQLException {
		try {
			Connection conn = dataSource.getConnection();
			String query = "update customer set first_name=? ,last_name=? , password=? where email_id=?";
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, customer.getFirst_name());
			p.setString(2, customer.getLast_name());
			p.setString(3, customer.getPassword());
			p.setString(4, customer.getEmail());

			System.out.println(customer.getFirst_name());
			System.out.println(customer.getLast_name());
			System.out.println(customer.getPassword());
			System.out.println(customer.getEmail());

			int rs = p.executeUpdate();
			return rs == 1 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
