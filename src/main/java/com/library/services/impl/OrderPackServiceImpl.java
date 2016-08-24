package com.library.services.impl;

import java.util.List;

import com.library.dao.OrderPackDao;
import com.library.entities.OrderPack;
import com.library.services.OrderPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tomasz Dębski
 *
 */
@Service
public class OrderPackServiceImpl implements OrderPackService {
	
	@Autowired
	OrderPackDao orderPackDao;

	@Override
	public OrderPack getOrderPackbyId(long id) {
		return orderPackDao.getOrderPackbyId(id);
	}

	@Override
	public List<OrderPack> getAllOrderPacks() {
		return orderPackDao.getAllOrderPacks();
	}

	@Override
	public void addOrderPack(OrderPack orderPack) {
		orderPackDao.addOrderPack(orderPack);
	}

	@Override
	public void updateOrderPack(OrderPack orderPack) {
		orderPackDao.updateOrderPack(orderPack);
	}

	@Override
	public void removeOrderPack(OrderPack orderPack) {
		orderPackDao.removeOrderPack(orderPack);
	}

}
