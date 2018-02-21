package br.com.consignum.colaboradores.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public abstract class Repository<T> {

	private Class<T> type;

	@Inject
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> result = (List<T>) em.createQuery("Select t from " + type.getName() + " t").getResultList();
		return result;
	}

	public void save(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public T merge(T t) {
		em.getTransaction().begin();
		t = em.merge(t);
		em.getTransaction().commit();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T find(T t) {
		em.getTransaction().begin();
		t = (T) em.find(type.getClass(), t);
		em.getTransaction().commit();
		return t;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

}
