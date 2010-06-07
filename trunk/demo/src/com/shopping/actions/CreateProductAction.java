package com.shopping.actions;

import com.opensymphony.xwork2.ActionSupport;

public class CreateProductAction extends ActionSupport {
	private static final long serialVersionUID = 201005281407L;
	private String productID;
	private String description;
	private String status;
	private long quantity;
	private float unitPrice;

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

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
