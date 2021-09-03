package com.tcss.springbootfinalassessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcss.springbootfinalassessment.entity.Questions;
import com.tcss.springbootfinalassessment.repository.IQuestionsRepository;


@Service
public class QuestionService implements IQuestionsService{
	
	@Autowired
	IQuestionsRepository questionRepository;

	@Override
	public void saveQuestion(Questions question) {
		questionRepository.save(question);
	}


	
	
}
