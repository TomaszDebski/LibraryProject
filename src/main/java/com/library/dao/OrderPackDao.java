package com.library.dao;

import com.library.entities.OrderPack;

import java.util.List;

/**
 * @author Tomasz Dębski
 *
 */
public interface OrderPackDao {

	OrderPack getOrderPackbyId(long id);
	
	List<OrderPack> getAllOrderPacks();
	
	void addOrderPack(OrderPack orderPack);
	
	void updateOrderPack(OrderPack orderPack);
	
	void removeOrderPack(OrderPack orderPack);
	
//	List<OrderPack> getAllOrderPacksWithoutId();
}
