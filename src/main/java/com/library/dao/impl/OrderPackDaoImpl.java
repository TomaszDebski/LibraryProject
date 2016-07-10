package com.library.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.library.dao.OrderPackDao;
import com.library.entities.OrderPack;
import org.springframework.stereotype.Repository;

/**
 * @author Tomasz Dębski
 *
 */
@Repository
@Transactional
public class OrderPackDaoImpl implements OrderPackDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public OrderPack getOrderPackbyId(long id) {
		return entityManager.find(OrderPack.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPack> getAllOrderPacks() {
		return entityManager.createQuery(
				"from OrderPack").getResultList();
	}

	@Override
	public void addOrderPack(OrderPack orderPack) {
		entityManager.persist(orderPack);
	}

	@Override
	public void updateOrderPack(OrderPack orderPack) {
		entityManager.merge(orderPack);
		
	}

	@Override
	public void removeOrderPack(OrderPack orderPack) {
		if(entityManager.contains(orderPack)){
			System.out.println("usuwam");
			entityManager.remove(orderPack);
		}
	}

//	@Override
//	public List<Book> getAllBooksWithoutId() {
//		return entityManager.createQuery("from Book b where b.bookReader.id is null").getResultList();
//	}
	
	

}
