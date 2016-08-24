package com.library.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.library.dao.BookReaderDao;
import com.library.entities.BookReader;
import org.springframework.stereotype.Repository;

/**
 * @author Tomasz Dębski
 *
 */
@Repository
@Transactional
public class BookReaderDaoImpl implements BookReaderDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public BookReader getBookReaderbyId(long id) {
		return entityManager.find(BookReader.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookReader> getAllBookReader() {
		return entityManager.createQuery(
				"from BookReader").getResultList();
	}

	@Override
	public void addBookReader(BookReader bookReader) {
		entityManager.persist(bookReader);
	}

	@Override
	public void updateBookReader(BookReader bookReader) {
		entityManager.merge(bookReader);
		
	}

	@Override
	public void removeBookReader(BookReader bookReader) {
		if(entityManager.contains(bookReader)){
			entityManager.remove(bookReader);
		}
	}

	@Override
	public BookReader getBookReaderByUsername(String username) {
		Query query = entityManager.createQuery("select a from BookReader a where a.readerName = ?1");
		query.setParameter(1, username);
		List<BookReader> resultList = query.getResultList();
		if (resultList.size() ==0){
			return null;
		}
		return resultList.get(0);
	}
}
