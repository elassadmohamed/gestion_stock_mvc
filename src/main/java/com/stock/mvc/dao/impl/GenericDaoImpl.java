package com.stock.mvc.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.stock.mvc.dao.IGenericDao;

public class GenericDaoImpl<E> implements IGenericDao<E> {

	@PersistenceContext
	EntityManager em;

	public Class<E> type;

	public Class<E> getType() {
		return type;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}

	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		em.merge(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("FROM " + type.getSimpleName()+ " t");
		return query.getResultList();
	}

	@Override
	public E getById(Long id) {

		return em.find(type, id);
	}

	@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> selectAll(String sortField, String sort) {
		Query query = em.createQuery("SELECT * FROM " + type.getSimpleName()
				+ " t order by " + sortField + " " + sort);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findOne(String paramName, Object paramValue) {
		Query query = em.createQuery("SELECT * FROM " + type.getSimpleName()
				+ " t where  " + paramName + "= :x");
		query.setParameter("x", paramValue);
		return query.getResultList().size() > 0 ? (E) query.getResultList()
				.get(0) : null;
	}

	@Override
	public E findOne(String[] paramNames, Object[] paramValues) {
		if(paramNames.length!=paramValues.length){
			return null;
		}
		String queryString="SELECT e FROM "+type.getSimpleName()+" e WHERE ";
		int len=paramNames.length;
		for(int i=0;i<len;i++){
			queryString+="e."+paramNames[i]+"= :x"+i;
			if((i+1)<len){
				queryString+=" and ";
			}
		}
		Query query=em.createQuery(queryString);
		for(int i=0;i<paramValues.length;i++){
			query.setParameter("x"+i,paramValues[i]);
		}
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		Query query = em.createQuery("SELECT * FROM " + type.getSimpleName()
				+ " t where  " + paramName + "= :x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? ((Long) query.getSingleResult()).intValue():0;
	}

}
