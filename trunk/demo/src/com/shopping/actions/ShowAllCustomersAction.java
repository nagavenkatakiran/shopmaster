package com.shopping.actions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.shopping.entities.Customer;
import com.shopping.services.CustomerService;
import com.shopping.services.impl.CustomerServiceImpl;

public class ShowAllCustomersAction extends ActionSupport {
	private static final long serialVersionUID = 201005281408L;

	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String execute() throws Exception {
		CustomerService customerService = new CustomerServiceImpl();
		Customer newCustomer = new Customer("barry10", "login4barry",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123",
				"3747 Gateway Lakes Drive, Grove City, OH, 43123", "best",
				"barry10@email.franklin.edu");
		Customer existingCustomer = customerService.getCustomer(newCustomer.getUserName());
		if (existingCustomer == null) {
			customerService.createCustomer(newCustomer);
		}
		
		Collection<Customer> existingCustomers = customerService.getCustomers();
		customers = new LinkedList<Customer>();
		for (Customer c : existingCustomers) {
			customers.add(c);
		}
		
		return SUCCESS;
	}
}
