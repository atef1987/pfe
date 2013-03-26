package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.ReponseDaoRemote;
import com.esprit.gestionPI.persistence.Reponse;

@Stateless
public class ReponseDao implements ReponseDaoRemote{

	@PersistenceContext
	EntityManager em;
	
	public void add(Reponse e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(Reponse e) {
		em.merge(e);
		
	}

	public Reponse findById(int id) {
		return em.find(Reponse.class, id);
	}

	public Set<Reponse> findAll() {
		return (Set<Reponse>) em.createQuery("select e from Reponse e").getResultList();
	}

}
