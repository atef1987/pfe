package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.dao.EnseignantDaoRemote;
import com.esprit.gestionPI.persistence.Enseignant;

public class EnseignantDao implements EnseignantDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(Enseignant e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Enseignant e) {
		em.merge(e);
		
	}

	@Override
	public Enseignant findById(int id) {
		
		return em.find(Enseignant.class, id);
	}

	@Override
	public Set<Enseignant> findAll() {
		
		return (Set<Enseignant>) em.createQuery("select e from Enseignant e").getResultList();
	}

}
