package com.shopping.services;

import java.util.Collection;

import com.shopping.entities.CustomerOrder;
import com.shopping.entities.OrderItem;
import com.shopping.entities.Product;

public interface OrderItemService {

	public OrderItem createOrderItem(OrderItem orderItem) throws Exception;

	public Collection<OrderItem> createOrderItems(
			Collection<OrderItem> orderItems);

	public OrderItem getOrderItem(long itemID);

	public Collection<OrderItem> getOrderItems(Product product);

	public Collection<OrderItem> getOrderItems(CustomerOrder customerOrder);

	public Collection<OrderItem> getOrderItems();

	public OrderItem updateOrderItem(OrderItem orderItem) throws Exception;

	public void deleteOrderItem(OrderItem orderItem) throws Exception;
}
