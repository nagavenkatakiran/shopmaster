package com.shopping.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {

	@Id
	@Column(name = "orderID")
	private long orderID;

	@ManyToOne(cascade = { CascadeType.MERGE })
	private Customer customer;

	@Column(name = "status")
	private String status;

	@Column(name = "totalCost")
	private float totalCost;

	@Column(name = "orderDate")
	private Date orderDate;

	public CustomerOrder() {
	}

	public CustomerOrder(long orderID, Customer customer, String status,
			float totalCost, Date orderDate) {
		this.orderID = orderID;
		this.customer = customer;
		this.status = status;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}