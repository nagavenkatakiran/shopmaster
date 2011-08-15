package com.shopping.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shopping.entities.Product;
import com.shopping.services.ProductService;
import com.shopping.services.impl.ProductServiceImpl;

public class CreateProductAction extends ActionSupport {
	private static final long serialVersionUID = 201005281407L;
	private String command;
	private String productID;
	private String description;
	private String status;
	private long quantity;
	private float unitPrice;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
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

	@Override
	public String execute() throws Exception {
		String rtn = SUCCESS;
		System.out.println(getClass().getName() + "::execute() -- command[" + command + "]");
		if (command != null && command.equals("Add Product")) {
			if (productID == null || productID.isEmpty()) {
				addActionError("Please enter a valid Product ID");
				return ERROR;
			}
			Product p = new Product();
			p.setProductID(productID);
			p.setDescription(description);
			p.setStatus(status);
			p.setQuantity(quantity);
			p.setUnitPrice(unitPrice);
			ProductService pService = new ProductServiceImpl();
			Product createdProduct = pService.createProduct(p);
			System.out.println(getClass().getName() + "::execute() -- createdProduct[" + createdProduct + "]");
			if (createdProduct != null) {
				addActionMessage("Successfully created a new product.");
				rtn = SUCCESS;
			} else {
				addActionError("Error: couldn't create a new product.");
				rtn = ERROR;
			}
		}
		return rtn;
	}
}
