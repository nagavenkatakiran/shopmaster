package com.shopping.business.impl;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import com.shopping.business.BusinessLogic;
import com.shopping.cart.CartItem;
import com.shopping.cart.CartOrder;
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

public class BusinessLogicImpl implements BusinessLogic {

	private CustomerService customerService;

	private OrderItemService orderItemService;

	private ProductService productService;

	private CustomerOrderService customerOrderService;

	public BusinessLogicImpl() {
		customerService = new CustomerServiceImpl();
		orderItemService = new OrderItemServiceImpl();
		productService = new ProductServiceImpl();
		customerOrderService = new CustomerOrderServiceImpl();
	}

	public void checkOut(CartOrder cartOrder) throws Exception {
		String userName = cartOrder.getUserName();
		Collection<CartItem> cartItems = cartOrder.getItems();

		long orderID = new Long(new Date().getTime());
		Customer customer = customerService.getCustomer(userName);
		String status = "order created";
		float totalCost = 0.0f;
		Date orderDate = new Date();
		CustomerOrder customerOrder = new CustomerOrder(orderID, customer,
				status, totalCost, orderDate);
		customerOrderService.createCustomerOrder(customerOrder);
		Collection<OrderItem> orderItems = new LinkedList<OrderItem>();
		for (CartItem cartItem : cartItems) {
			long itemID = new Long(new Date().getTime());
			Product product = cartItem.getProduct();
			long quantity = cartItem.getQuantity();
			OrderItem orderItem = new OrderItem(itemID++, product,
					customerOrder, quantity);
			orderItems.add(orderItem);
			// update the product quantity and the order's total cost
			product.setQuantity(product.getQuantity() - quantity);
			productService.updateProduct(product);
			totalCost += product.getUnitPrice() * cartItem.getQuantity();
			break;
		}
		orderItemService.createOrderItems(orderItems);
		customerOrder.setTotalCost(totalCost);
		customerOrderService.updateCustomerOrder(customerOrder);
	}
}
