package com.shopping.business.impl;

import java.util.Collection;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.shopping.business.BusinessLogic;
import com.shopping.cart.CartItem;
import com.shopping.cart.CartOrder;
import com.shopping.entities.Customer;
import com.shopping.entities.CustomerOrder;
import com.shopping.entities.Product;
import com.shopping.services.CustomerOrderService;
import com.shopping.services.CustomerService;
import com.shopping.services.ProductService;
import com.shopping.services.impl.CustomerOrderServiceImpl;
import com.shopping.services.impl.CustomerServiceImpl;
import com.shopping.services.impl.ProductServiceImpl;

public class BusinessLogicTest {

	private BusinessLogic logic;

	@Before
	public void before() throws Exception {
		logic = new BusinessLogicImpl();
	}

	@Test
	public void testCheckOut() throws Exception {
		Customer customer = new Customer("barry10", "login4barry",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123", "9",
				"barry10@email.franklin.edu");
		CustomerService customerService = new CustomerServiceImpl();
		customerService.createCustomer(customer);
		ProductService productService = new ProductServiceImpl();
		Product product1 = productService.createProduct(new Product("1",
				"Computer Hardware", "in-stock", 3L, 3.0f));
		long quantity1 = 1L;
		CartItem item1 = new CartItem(product1, quantity1);
		String userName = customer.getUserName();
		Collection<CartItem> cartItems = new LinkedList<CartItem>();
		cartItems.add(item1);
		CartOrder cartOrder = new CartOrder(userName, cartItems);
		logic.checkOut(cartOrder);

		// product quantity should change, as well as the order's total cost
		Product existingProduct = productService.getProduct(product1
				.getProductID());
		Assert.assertNotNull(existingProduct);
		Assert.assertEquals(2L, existingProduct.getQuantity());

		CustomerOrderService customerOrderService = new CustomerOrderServiceImpl();
		Collection<CustomerOrder> existingOrders = customerOrderService
				.getCustomerOrders(customer);
		Assert.assertNotNull(existingOrders);
		Assert.assertEquals(1, existingOrders.size());
		Assert.assertEquals(3.0f, existingOrders.iterator().next()
				.getTotalCost());
	}
}
