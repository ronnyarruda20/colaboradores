package br.com.consignum.colaboradores.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Repository {

	@PersistenceContext(name = "PersistentUnitName")
	protected EntityManager entityManager;

}
