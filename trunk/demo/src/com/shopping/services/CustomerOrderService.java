package com.shopping.services;

import java.util.Collection;

import com.shopping.entities.Customer;
import com.shopping.entities.CustomerOrder;

public interface CustomerOrderService {

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder)
			throws Exception;

	public Collection<CustomerOrder> getCustomerOrders(Customer customer);

	public CustomerOrder getCustomerOrder(long orderID);

	public Collection<CustomerOrder> getCustomerOrders();

	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder)
			throws Exception;

	public void deleteCustomerOrder(CustomerOrder customerOrder)
			throws Exception;
}
