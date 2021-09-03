package com.tcss.springbootfinalassessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcss.springbootfinalassessment.entity.Questions;
import com.tcss.springbootfinalassessment.exception.NotValidQuestion;
import com.tcss.springbootfinalassessment.exception.QuestionNotFoundException;
import com.tcss.springbootfinalassessment.repository.IQuestionsRepository;

@Service
public class QuestionService implements IQuestionsService {

	@Autowired
	IQuestionsRepository questionRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveQuestion(Questions question) {
		questionRepository.save(question);
	}

	@Override
	public Iterable<Questions> retrieveAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Optional<Questions> retreiveQuestion(long id) {
		Optional<Questions> findById = questionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Question does not exist");
		}
		return findById;
	}

	@Override
	public void deleteQuestion(long id) {
		Optional<Questions> findById = questionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Question does not exist");
		}
		questionRepository.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateQuestion(long id, Questions question) {
		Optional<Questions> findById = questionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Question does not exist");
		}
		Questions ques = findById.get();
		if(ques.getQuestion() == null) {
			throw new NotValidQuestion("Question is not valid");
		}
		questionRepository.save(question);
	}

}
