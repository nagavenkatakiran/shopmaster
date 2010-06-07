package com.shopping.services.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.shopping.entities.Customer;
import com.shopping.entities.CustomerOrder;
import com.shopping.persistence.PersistenceManager;
import com.shopping.services.CustomerOrderService;

public class CustomerOrderServiceImpl implements CustomerOrderService {

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder)
			throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(customerOrder);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customerOrder;
	}

	public void deleteCustomerOrder(CustomerOrder customerOrder)
			throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			customerOrder = em.merge(customerOrder);
			em.remove(customerOrder);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}
	}

	public Collection<CustomerOrder> getCustomerOrders(Customer customer) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em
				.createQuery("select co from CustomerOrder co where co.customer = '"
						+ customer.getUserName() + "'");
		@SuppressWarnings("unchecked")
		Collection<CustomerOrder> customerOrders = (Collection<CustomerOrder>) query.getResultList();
		return customerOrders;
	}

	public CustomerOrder getCustomerOrder(long orderID) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CustomerOrder customerOrder = null;
		try {
			tx.begin();
			customerOrder = em.find(CustomerOrder.class, orderID);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customerOrder;
	}

	public Collection<CustomerOrder> getCustomerOrders() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em.createQuery("select co from CustomerOrder co");
		@SuppressWarnings("unchecked")
		Collection<CustomerOrder> customerOrders = (Collection<CustomerOrder>) query.getResultList();
		return customerOrders;
	}

	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder)
			throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			customerOrder = em.merge(customerOrder);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customerOrder;
	}
}
