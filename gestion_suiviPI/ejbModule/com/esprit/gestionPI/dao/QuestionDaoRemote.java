package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Question;

@Remote
public interface QuestionDaoRemote {
	void add(Question e);

	void delete(int id);

	void update(Question e);

	Question findById(int id);
	
	Set<Question> findAll();

}
