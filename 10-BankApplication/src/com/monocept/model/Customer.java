package com.monocept.model;

public class Customer {
	private int cust_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer(int cust_id, String first_name, String last_name, String email, String password) {
		super();
		this.cust_id = cust_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}
	public Customer(String email, String f_name, String l_name, String pass) {
		
		this.email = email;
		this.first_name = f_name;
		this.last_name = l_name;
		
		this.password = pass;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + "]";
	}
	
	

}
