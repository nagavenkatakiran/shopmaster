package com.shopping.services.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.shopping.entities.Product;
import com.shopping.services.ProductService;
import com.shopping.services.impl.ProductServiceImpl;

public class ProductServiceTest {

	private ProductService service;
	private Product product;

	@Before
	public void before() throws Exception {
		service = new ProductServiceImpl();
		product = new Product("1", "Computer Hardware", "Available", 2L, 500.0f);
	}

	@Test
	public void testProductServices() throws Exception {
		Product createdProduct = service.createProduct(product);
		Assert.assertNotNull(createdProduct);
		Assert.assertEquals(product.getProductID(), createdProduct
				.getProductID());
		Assert.assertEquals("1", createdProduct.getProductID());
		Assert.assertEquals("Computer Hardware", createdProduct
				.getDescription());

		Product existingProduct = service.getProduct(product.getProductID());
		Assert.assertNotNull(existingProduct);
		Assert.assertEquals("Available", existingProduct.getStatus());
		
		existingProduct = service.getProduct("1");
		existingProduct.setDescription("Television");
		existingProduct.setQuantity(1L);
		Product updatedProduct = service.updateProduct(existingProduct);
		Assert.assertEquals("Television", updatedProduct.getDescription());
		Assert.assertEquals(1L, updatedProduct.getQuantity());
		Assert.assertEquals(500.0f, updatedProduct.getUnitPrice());

		Collection<Product> existingProducts = service.getProducts();
		Assert.assertEquals(1, existingProducts.size());
		Assert.assertEquals("1", existingProducts.iterator().next()
				.getProductID());

		service.deleteProduct(product);
		Assert.assertNull(service.getProduct("1"));
		Assert.assertEquals(0, service.getProducts().size());
	}
}
