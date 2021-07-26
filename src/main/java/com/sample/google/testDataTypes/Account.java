package com.sample.google.testDataTypes;

public class Account {
	public String email;
	public String password;
	
	/**
	 * Constructor to assign provided value to account password record
	 * @param email - Email
	 * @param password - Password
	 */
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Method to read email value
	 * @return - Email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Method to read password value
	 * @return - Password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Method to set email value
	 * @param email - Email Address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Method to set password value
	 * @param password - Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}