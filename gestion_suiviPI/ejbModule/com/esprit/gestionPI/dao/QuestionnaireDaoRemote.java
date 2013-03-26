package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Questionnaire;

@Remote
public interface QuestionnaireDaoRemote {
	void add(Questionnaire e);

	void delete(int id);

	void update(Questionnaire e);

	Questionnaire findById(int id);
	
	Set<Questionnaire> findAll();

}
