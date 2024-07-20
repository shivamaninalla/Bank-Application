package com.monocept.model;

public class Accounts {
	
	private int account_number;
	private int cust_id;
	private double balance;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Accounts(int account_number, int cust_id, double balance) {
		super();
		this.account_number = account_number;
		this.cust_id = cust_id;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Accounts [account_number=" + account_number + ", cust_id=" + cust_id + ", balance=" + balance + "]";
	}
	
	

}
