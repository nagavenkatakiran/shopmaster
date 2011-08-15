package com.shopping.actions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.shopping.entities.Product;
import com.shopping.services.ProductService;
import com.shopping.services.impl.ProductServiceImpl;

public class ShowAllProductsAction extends ActionSupport {
	private static final long serialVersionUID = 201005281409L;

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String execute() throws Exception {
		ProductService productService = new ProductServiceImpl();
		Collection<Product> existingProducts = productService.getProducts();
		products = new LinkedList<Product>();
		for (Product product : existingProducts) {
			products.add(product);
		}
		
		return SUCCESS;
	}
}
