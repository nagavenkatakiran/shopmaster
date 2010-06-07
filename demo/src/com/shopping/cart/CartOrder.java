package com.shopping.cart;

import java.util.Collection;

public class CartOrder {

	private String userName;

	private Collection<CartItem> items;

	public CartOrder() {
	}

	public CartOrder(String userName, Collection<CartItem> items) {
		this.userName = userName;
		this.items = items;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<CartItem> getItems() {
		return items;
	}

	public void setItems(Collection<CartItem> items) {
		this.items = items;
	}
}
