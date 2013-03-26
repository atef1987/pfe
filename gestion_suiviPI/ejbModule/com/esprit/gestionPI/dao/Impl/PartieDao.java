package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.PartieDaoRemote;
import com.esprit.gestionPI.persistence.Partie;

@Stateless
public class PartieDao implements PartieDaoRemote {
	@PersistenceContext
	EntityManager em;

	public void add(Partie e) {
		em.persist(e);

	}

	public void delete(int id) {
		em.remove(findById(id));

	}

	public void update(Partie e) {
		em.merge(e);

	}


	public Partie findById(int id) {
		return em.find(Partie.class, id);
	}


	public Set<Partie> findAll() {
		return (Set<Partie>) em.createQuery("select e from partie e").getResultList();
	}

}
