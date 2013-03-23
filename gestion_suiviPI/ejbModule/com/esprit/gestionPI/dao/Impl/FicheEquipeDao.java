package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.gestionPI.dao.FicheEquipeDaoRemote;
import com.esprit.gestionPI.persistence.FicheEquipe;
@Stateless
public class FicheEquipeDao implements FicheEquipeDaoRemote {
@PersistenceContext
EntityManager em;
	@Override
	public void add(FicheEquipe e) {
		em.persist(e);
		
	}

	@Override
	public void delete(int id) {
		
		em.remove(findById(id));
	}

	@Override
	public void update(FicheEquipe e) {
		em.merge(e);
		
	}

	@Override
	public FicheEquipe findById(int id) {
		
		return em.find(FicheEquipe.class, id);
	}

	@Override
	public Set<FicheEquipe> findAll() {
		
		return (Set<FicheEquipe>) em.createQuery("select e from FicheEquipe e").getResultList();
	}

}
