package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.dao.FicheDaoRemote;
import com.esprit.gestionPI.persistence.Fiche;

public class FicheDao implements FicheDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(Fiche e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Fiche e) {
		em.merge(e);
		
	}

	@Override
	public Fiche findById(int id) {
		
		return em.find(Fiche.class, id);
	}

	@Override
	public Set<Fiche> findAll() {
		
		return (Set<Fiche>) em.createQuery("select e from Fiche e").getResultList();
	}

}
