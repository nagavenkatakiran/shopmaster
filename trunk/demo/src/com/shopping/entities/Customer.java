package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "shippingAddress")
	private String shippingAddress;
	
	@Column(name = "billingAddress")
	private String billingAddress;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "emailAddress")
	private String emailAddress;

	public Customer() {
	}

	public Customer(String userName, String password, String shippingAddress,
			String billingAddress, String rating, String emailAddress) {
		this.userName = userName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.rating = rating;
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
