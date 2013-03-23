package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.EtudiantDaoRemote;
import com.esprit.gestionPI.persistence.Etudiant;

public class EtudiantDao implements EtudiantDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(Etudiant e) {
		
		em.persist(e);
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(Etudiant e) {
		em.merge(e);
		
	}

	@Override
	public Etudiant findById(int id) {
		
		return em.find(Etudiant.class, id);
	}

	@Override
	public Set<Etudiant> findAll() {
		
		return (Set<Etudiant>) em.createQuery("select e from Etudiant e").getResultList();
	}

}
