package br.com.consignum.colaboradores.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class Repository<T> {
	
	private Class<T> type;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) em.createQuery("Select t from " + type.getName() + " t").getResultList();
	}
	
	public T merge(T t) {
		return em.merge(t);
	}

	public T find(Integer id) {
		return  (T) em.find(type, id);
	}
	
	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

}
