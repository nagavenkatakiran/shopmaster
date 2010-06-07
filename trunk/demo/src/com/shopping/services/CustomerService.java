package com.shopping.services;

import java.util.Collection;

import com.shopping.entities.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws Exception;

	public Customer getCustomer(String userName);

	public Collection<Customer> getCustomers();

	public Customer updateCustomer(Customer customer) throws Exception;
	
	public void deleteCustomer(Customer customer) throws Exception;

}
