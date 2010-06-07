package com.shopping.services.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.shopping.entities.Customer;
import com.shopping.services.CustomerService;
import com.shopping.services.impl.CustomerServiceImpl;

public class CustomerServiceTest {

	@Test
	public void testCreateRetrieveUpdateDeleteCustomer() throws Exception {
		CustomerService service = new CustomerServiceImpl();
		Customer customer = new Customer("barry10", "login4barry",
				"3747 Gateway Lakes Drive", "3747 Gateway Lakes Drive", "8",
				"barry10@email.franklin.edu");
		Customer customerCreated = service.createCustomer(customer);
		Assert.assertNotNull(customerCreated);
		Assert.assertEquals(customer.getUserName(), customerCreated.getUserName());
		Assert.assertEquals("barry10", customerCreated.getUserName());
		Assert.assertEquals("barry10@email.franklin.edu", customerCreated.getEmailAddress());
		
		Customer existingCustomer = service.getCustomer("barry10");
		Assert.assertNotNull(existingCustomer);
		Assert.assertEquals("3747 Gateway Lakes Drive", existingCustomer.getShippingAddress());
		Assert.assertEquals("barry10", existingCustomer.getUserName());
		
		existingCustomer.setShippingAddress("1302 Waterford Drive");
		existingCustomer.setEmailAddress("barrye@franklin.edu");
		Customer updatedCustomer = service.updateCustomer(existingCustomer);
		Assert.assertEquals("barry10", updatedCustomer.getUserName());
		Assert.assertEquals("1302 Waterford Drive", updatedCustomer.getShippingAddress());
		Assert.assertEquals("barrye@franklin.edu", updatedCustomer.getEmailAddress());
		
		Collection<Customer> existingCustomers = service.getCustomers();
		Assert.assertEquals(1, existingCustomers.size());
		Assert.assertEquals("barry10", existingCustomers.iterator().next().getUserName());
		
		service.deleteCustomer(existingCustomer);
		Assert.assertNull(service.getCustomer("barry10"));
		Assert.assertEquals(0, service.getCustomers().size());
	}
}
