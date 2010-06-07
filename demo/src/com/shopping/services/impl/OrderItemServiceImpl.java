package com.shopping.services.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.shopping.entities.CustomerOrder;
import com.shopping.entities.OrderItem;
import com.shopping.entities.Product;
import com.shopping.persistence.PersistenceManager;
import com.shopping.services.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

	public OrderItem createOrderItem(OrderItem orderItem) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(orderItem);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return orderItem;
	}

	public Collection<OrderItem> createOrderItems(
			Collection<OrderItem> orderItems) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			for (OrderItem item : orderItems) {
				em.persist(item);
			}
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return orderItems;
	}

	public void deleteOrderItem(OrderItem orderItem) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			orderItem = em.merge(orderItem);
			em.remove(orderItem);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}
	}

	public OrderItem getOrderItem(long itemID) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		OrderItem orderItem = null;
		try {
			tx.begin();
			orderItem = em.find(OrderItem.class, itemID);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return orderItem;
	}

	public Collection<OrderItem> getOrderItems(Product product) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em
				.createQuery("select item from OrderItem item where item.product = '"
						+ product.getProductID() + "'");
		@SuppressWarnings("unchecked")
		Collection<OrderItem> orderItems = (Collection<OrderItem>) query.getResultList();
		return orderItems;
	}

	public Collection<OrderItem> getOrderItems(CustomerOrder customerOrder) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em
				.createQuery("select item from OrderItem item where item.customerOrder = '"
						+ customerOrder.getOrderID() + "'");
		@SuppressWarnings("unchecked")
		Collection<OrderItem> orderItems = (Collection<OrderItem>) query.getResultList();
		return orderItems;
	}

	public Collection<OrderItem> getOrderItems() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em.createQuery("select item from OrderItem item");
		@SuppressWarnings("unchecked")
		Collection<OrderItem> orderItems = (Collection<OrderItem>) query.getResultList();
		return orderItems;
	}

	public OrderItem updateOrderItem(OrderItem orderItem) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			orderItem = em.merge(orderItem);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return orderItem;
	}
}
