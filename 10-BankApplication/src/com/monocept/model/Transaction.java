package com.monocept.model;

import java.util.Date;

public class Transaction {
	
	private int transaction_number;
	private int sender_account_number;
	private int receiver_account_number;
	private String date_of_transaction;
	private String transaction_type;
	private double transaction_amount;
	@Override
	public String toString() {
		return "Transaction [transaction_number=" + transaction_number + ", sender_account_number="
				+ sender_account_number + ", receiver_account_number=" + receiver_account_number
				+ ", date_of_transaction=" + date_of_transaction + ", transaction_type=" + transaction_type
				+ ", transaction_amount=" + transaction_amount + "]";
	}
	public Transaction(int transaction_number, int sender_account_number, int receiver_account_number,
			String date_of_transaction, String transaction_type, double transaction_amount) {
		super();
		this.transaction_number = transaction_number;
		this.sender_account_number = sender_account_number;
		this.receiver_account_number = receiver_account_number;
		this.date_of_transaction = date_of_transaction;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
	}
	public Transaction(int senderAccountNumber, int receiverAccountNumber, String type, double amount, String date) {
		
		this.sender_account_number = senderAccountNumber;
		this.receiver_account_number=receiverAccountNumber;
		this.transaction_type=type;
		this.transaction_amount = amount;
		this.date_of_transaction=date;
	}
	
	public int getTransaction_number() {
		return transaction_number;
	}
	public void setTransaction_number(int transaction_number) {
		this.transaction_number = transaction_number;
	}
	public int getSender_account_number() {
		return sender_account_number;
	}
	public void setSender_account_number(int sender_account_number) {
		this.sender_account_number = sender_account_number;
	}
	public int getReceiver_account_number() {
		return receiver_account_number;
	}
	public void setReceiver_account_number(int receiver_account_number) {
		this.receiver_account_number = receiver_account_number;
	}
	public String getDate_of_transaction() {
		return date_of_transaction;
	}
	public void setDate_of_transaction(String date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	
}
