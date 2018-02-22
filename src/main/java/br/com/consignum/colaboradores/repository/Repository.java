package br.com.consignum.colaboradores.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public abstract class Repository<T> {

	private Class<T> type;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> lista = null;
		try {
			lista = (List<T>) em.createQuery("Select t from " + type.getName() + " t").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
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
	
	public T find(Integer id) {
		T t = null;
		em.getTransaction().begin();
		t = (T) em.find(type, id);
		em.getTransaction().commit();
		return t;
	}
	
	public void remove(T t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}
	
	

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
