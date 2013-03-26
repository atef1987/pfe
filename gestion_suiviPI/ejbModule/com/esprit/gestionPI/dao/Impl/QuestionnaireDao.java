package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.QuestionnaireDaoRemote;
import com.esprit.gestionPI.persistence.Questionnaire;

@Stateless
public class QuestionnaireDao implements QuestionnaireDaoRemote{

	@PersistenceContext
	EntityManager em;
	
	public void add(Questionnaire e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(Questionnaire e) {
		em.merge(e);
		
	}

	public Questionnaire findById(int id) {
	     return em.find(Questionnaire.class, id);
	}

	public Set<Questionnaire> findAll() {
		return (Set<Questionnaire>) em.createQuery("select e from Questionnaire e").getResultList();
	}

}
