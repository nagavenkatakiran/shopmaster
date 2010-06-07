package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@Column(name = "productID")
	private String productID;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "unitPrice")
	private float unitPrice;

	public Product() {
	}

	public Product(String productID, String description, String status,
			long quantity, float unitPrice) {
		this.productID = productID;
		this.description = description;
		this.status = status;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
