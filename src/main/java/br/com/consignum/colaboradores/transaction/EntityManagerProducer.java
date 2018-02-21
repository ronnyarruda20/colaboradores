package br.com.consignum.colaboradores.transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private final EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("ColaboradorPU");
	}

	@Produces
	@RequestScoped
	@Default
	public EntityManager create() {
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		manager.close();
	}

}
