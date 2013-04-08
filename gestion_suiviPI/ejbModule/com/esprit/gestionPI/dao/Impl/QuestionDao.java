package com.esprit.gestionPI.dao.Impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.gestionPI.dao.QuestionDaoRemote;
import com.esprit.gestionPI.persistence.Question;

@Stateless
public class QuestionDao implements QuestionDaoRemote{

	@PersistenceContext
	EntityManager em;
	
	public void add(Question e) {
		em.persist(e);
		
	}

	public void delete(int id) {
		em.remove(findById(id));
		
	}

	public void update(Question e) {
		em.merge(e);
		
	}

	public Question findById(int id) {
		return em.find(Question.class,id);
	}

	public Set<Question> findAll() {
		return (Set<Question>) em.createQuery("select e from question e").getResultList();
	}

}
