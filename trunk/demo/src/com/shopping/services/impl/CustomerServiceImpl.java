package com.shopping.services.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.shopping.entities.Customer;
import com.shopping.persistence.PersistenceManager;
import com.shopping.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	public Customer createCustomer(Customer customer) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(customer);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customer;
	}

	public void deleteCustomer(Customer customer) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			customer = em.merge(customer);
			em.remove(customer);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}
	}

	public Customer getCustomer(String userName) {
		Customer customer = null;
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			customer = em.find(Customer.class, userName);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customer;
	}

	public Collection<Customer> getCustomers() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em.createQuery("select c from Customer c");
		@SuppressWarnings("unchecked")
		Collection<Customer> customers = (Collection<Customer>) query.getResultList();
		return customers;
	}
	
	public Customer updateCustomer(Customer customer) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			customer = em.merge(customer);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return customer;
	}
}
