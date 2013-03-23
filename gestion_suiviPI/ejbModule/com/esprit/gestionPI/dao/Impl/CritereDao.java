package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.dao.CritereDaoRemote;
import com.esprit.gestionPI.persistence.Critere;

public class CritereDao implements CritereDaoRemote {
@PersistenceContext 
EntityManager em;
	@Override
	public void add(Critere e) {
		em.persist(e);
		
	}

	
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Critere e) {
		em.merge(e);
		
	}

	@Override
	public Critere findById(int id) {
		
		return em.find(Critere.class, id);
	}

	@Override
	public Set<Critere> findAll() {
		
		return (Set<Critere>) em.createQuery("select e from Critere e").getResultList();
	}

}
