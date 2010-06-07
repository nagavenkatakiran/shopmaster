package com.shopping.services.test;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.shopping.entities.Customer;
import com.shopping.entities.CustomerOrder;
import com.shopping.entities.OrderItem;
import com.shopping.entities.Product;
import com.shopping.services.CustomerOrderService;
import com.shopping.services.CustomerService;
import com.shopping.services.OrderItemService;
import com.shopping.services.ProductService;
import com.shopping.services.impl.CustomerOrderServiceImpl;
import com.shopping.services.impl.CustomerServiceImpl;
import com.shopping.services.impl.OrderItemServiceImpl;
import com.shopping.services.impl.ProductServiceImpl;

public class OrderItemServiceTest {

	private OrderItemService service;
	private OrderItem orderItem;
	private Product product;
	private ProductService productService;
	private CustomerOrder customerOrder;
	private CustomerOrderService customerOrderService;
	private Customer customer;
	private CustomerService customerService;

	@Before
	public void before() throws Exception {
		service = new OrderItemServiceImpl();
		productService = new ProductServiceImpl();
		customerOrderService = new CustomerOrderServiceImpl();
		customerService = new CustomerServiceImpl();
		customer = new Customer("barry10", "login4barry",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123", "9",
				"barry10@email.franklin.edu");
		customer = customerService.createCustomer(customer);
		Date orderDate = new GregorianCalendar(2010, 04, 28).getTime();
		customerOrder = new CustomerOrder(1L, customer, "pending", 0.5f,
				orderDate);
		customerOrder = customerOrderService.createCustomerOrder(customerOrder);
		product = new Product("1", "Computer Hardware", "in-store", 3L, 3.0f);
		product = productService.createProduct(product);
		orderItem = new OrderItem(1L, product, customerOrder, 2L);
	}

	@Test
	public void testOrderItemServices() throws Exception {
		OrderItem createdItem = service.createOrderItem(orderItem);
		Assert.assertNotNull(createdItem);
		Assert.assertEquals(orderItem.getItemID(), createdItem.getItemID());
		Assert.assertEquals(orderItem, createdItem);

		OrderItem existingItem = service.getOrderItem(createdItem.getItemID());
		Assert.assertNotNull(existingItem);
		Assert.assertEquals(2L, existingItem.getQuantity());
		Assert.assertEquals("in-store", existingItem.getProduct().getStatus());
		Assert.assertEquals(0.5f, existingItem.getCustomerOrder()
				.getTotalCost());

		existingItem.setQuantity(0L);
		OrderItem updatedItem = service.updateOrderItem(existingItem);
		Assert.assertEquals(0L, updatedItem.getQuantity());

		Collection<OrderItem> existingItems = service.getOrderItems(product);
		Assert.assertNotNull(existingItems);
		Assert.assertEquals(1, existingItems.size());

		existingItems = service.getOrderItems(customerOrder);
		Assert.assertNotNull(existingItems);
		Assert.assertEquals(1, existingItems.size());

		service.deleteOrderItem(orderItem);
		Assert.assertNull(service.getOrderItem(orderItem.getItemID()));
		Assert.assertEquals(0, service.getOrderItems().size());

		OrderItem orderItem2 = new OrderItem(2L, product, customerOrder, 10L);
		Collection<OrderItem> orderItems = new LinkedList<OrderItem>();
		orderItems.add(orderItem);
		orderItems.add(orderItem2);
		Collection<OrderItem> createdItems = service
				.createOrderItems(orderItems);
		Assert.assertEquals(orderItems.size(), createdItems.size());
		service.deleteOrderItem(orderItem);
		service.deleteOrderItem(orderItem2);
		customerOrderService.deleteCustomerOrder(customerOrder);
		customerService.deleteCustomer(customer);
		productService.deleteProduct(product);
	}
}
