package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.FicheEtudiantDaoRemote;
import com.esprit.gestionPI.persistence.FicheEtudiant;

public class FicheEtudiantDao implements FicheEtudiantDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(FicheEtudiant e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
		
	}

	@Override
	public void update(FicheEtudiant e) {
		em.merge(e);
		
	}

	@Override
	public FicheEtudiant findById(int id) {
	
		return em.find(FicheEtudiant.class, id);
	}

	@Override
	public Set<FicheEtudiant> findAll() {
		
		return (Set<FicheEtudiant>) em.createQuery("select e from FicheEtudiant e").getResultList();
	}

}
