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
		Product newProduct = new Product("1", "Computer Hardware", "in-stock", 2L, 24.99f);
		Product existingProduct = productService.getProduct(newProduct.getProductID());
		if (existingProduct == null) {
			productService.createProduct(newProduct);
		}
		
		newProduct = new Product("2", "Television HD", "out-of-stock", 1L, 95.06f);
		existingProduct = productService.getProduct(newProduct.getProductID());
		if (existingProduct == null) {
			productService.createProduct(newProduct);
		}
		
		Collection<Product> existingProducts = productService.getProducts();
		products = new LinkedList<Product>();
		for (Product product : existingProducts) {
			products.add(product);
		}
		
		return SUCCESS;
	}
}
