package com.shopping.services.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.shopping.entities.Product;
import com.shopping.persistence.PersistenceManager;
import com.shopping.services.ProductService;

public class ProductServiceImpl implements ProductService {

	public Product createProduct(Product product) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(product);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return product;
	}

	public void deleteProduct(Product product) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			product = em.merge(product);
			em.remove(product);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}
	}

	public Product getProduct(String productID) {
		Product product = null;
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			product = em.find(Product.class, productID);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return product;
	}

	public Collection<Product> getProducts() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = em.createQuery("select p from Product p");
		@SuppressWarnings("unchecked")
		Collection<Product> products = (Collection<Product>) query.getResultList();
		return products;
	}

	public Product updateProduct(Product product) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			product = em.merge(product);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return product;
	}
}
