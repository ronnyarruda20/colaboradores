package br.com.consignum.colaboradores.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@Transactional
public abstract class Repository2<T> {

	private Class<T> type;

	@PersistenceUnit(unitName = "ColaboradorDB")
	protected EntityManagerFactory emf;
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		em = emf.createEntityManager();
		List<T> result = (List<T>) em.createQuery("Select t from " + type.getName() + " t").getResultList();
		em.close();
		return result;
	}

	public void save(T t) {
		em = emf.createEntityManager();
		em.persist(t);
		em.close();
	}

	public T merge(T t) {
		em = emf.createEntityManager();
		t = em.merge(t);
		em.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T find(T t) {
		em = emf.createEntityManager();
		t = (T) em.find(type.getClass(), t);
		em.close();
		return t;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

}
