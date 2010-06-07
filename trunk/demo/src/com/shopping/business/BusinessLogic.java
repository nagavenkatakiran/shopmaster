package com.shopping.business;

import com.shopping.cart.CartOrder;

public interface BusinessLogic {

	public void checkOut(CartOrder cartOrder) throws Exception;
}
