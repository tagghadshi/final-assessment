package com.tcss.springbootfinalassessment.service;

import java.util.Optional;

import com.tcss.springbootfinalassessment.entity.Questions;

public interface IQuestionsService {
	void saveQuestion(Questions question);
	Iterable<Questions> retrieveAllQuestion();
	Optional<Questions> retreiveQuestion(long id);
	void deleteQuestion(long id);
	void updateQuestion(long id,Questions question);
}
