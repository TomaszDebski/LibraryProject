package com.library.services;

import com.library.entities.OrderPack;

import java.util.List;

public interface OrderPackService {

	OrderPack getOrderPackbyId(long id);
	
	List<OrderPack> getAllOrderPacks();
	
	void addOrderPack(OrderPack orderPack);
	
	void updateOrderPack(OrderPack orderPack);
	
	void removeOrderPack(OrderPack orderPack);
	
//	List<Book> getAllBooksWithoutId();
	
}
