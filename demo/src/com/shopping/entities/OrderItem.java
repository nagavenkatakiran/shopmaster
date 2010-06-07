package com.shopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

	@Id
	@Column(name = "itemID")
	private long itemID;

	@ManyToOne(cascade = { CascadeType.MERGE })
	private Product product;

	@ManyToOne(cascade = { CascadeType.MERGE })
	private CustomerOrder customerOrder;

	@Column(name = "quantity")
	private long quantity;

	public OrderItem() {
	}

	public OrderItem(long itemID, Product product, CustomerOrder customerOrder,
			long quantity) {
		this.itemID = itemID;
		this.product = product;
		this.customerOrder = customerOrder;
		this.quantity = quantity;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
