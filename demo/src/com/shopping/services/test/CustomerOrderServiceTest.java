package com.shopping.services.test;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.shopping.entities.Customer;
import com.shopping.entities.CustomerOrder;
import com.shopping.services.CustomerOrderService;
import com.shopping.services.CustomerService;
import com.shopping.services.impl.CustomerOrderServiceImpl;
import com.shopping.services.impl.CustomerServiceImpl;

public class CustomerOrderServiceTest {

	private CustomerOrderService service;
	private CustomerOrder customerOrder;
	private Customer customer;
	private CustomerService customerService;

	@Before
	public void before() throws Exception {
		service = new CustomerOrderServiceImpl();
		customerService = new CustomerServiceImpl();
		customer = new Customer("barry10", "login4barry",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123", "8",
				"barry10@email.franklin.edu");
		customer = customerService.createCustomer(customer);
		Date orderDate = new GregorianCalendar(2010, 4, 28).getTime();
		customerOrder = new CustomerOrder(1L, customer, "pending", 230.0f,
				orderDate);
	}

	@Test
	public void testCustomerOrderServices() throws Exception {
		CustomerOrder createdOrder = service.createCustomerOrder(customerOrder);
		Assert.assertNotNull(createdOrder);
		Assert.assertEquals(customerOrder.getOrderID(), createdOrder
				.getOrderID());
		Assert.assertEquals(customerOrder.getCustomer().getUserName(),
				createdOrder.getCustomer().getUserName());

		CustomerOrder existingOrder = service.getCustomerOrder(createdOrder
				.getOrderID());
		Assert.assertNotNull(existingOrder);
		Assert.assertEquals("pending", existingOrder.getStatus());

		existingOrder.setStatus("complete");
		CustomerOrder updatedOrder = service.updateCustomerOrder(existingOrder);
		Assert.assertEquals("complete", updatedOrder.getStatus());

		Collection<CustomerOrder> existingCustomerOrders = service
				.getCustomerOrders(customer);
		Assert.assertEquals(1, existingCustomerOrders.size());
		Assert.assertEquals(1L, existingCustomerOrders.iterator().next()
				.getOrderID());

		service.deleteCustomerOrder(customerOrder);
		Assert.assertNotNull(customerOrder);
		Assert.assertEquals(0, service.getCustomerOrders().size());
		customerService.deleteCustomer(customer);
	}

}
