package br.com.consignum.colaboradores.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Repository2<T1, T2> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<T1> findAll(){
		return ((List<T1>) entityManager.createQuery("Select * from T1").getResultList());
	}

}
