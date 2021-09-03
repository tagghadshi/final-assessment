package com.tcss.springbootfinalassessment.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcss.springbootfinalassessment.entity.Questions;
import com.tcss.springbootfinalassessment.exception.QuestionNotFoundException;
import com.tcss.springbootfinalassessment.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionsController.class);

	@Autowired
	QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<Object> saveQuestion(@RequestBody Questions question) {
		questionService.saveQuestion(question);
		logger.debug("Saved in Database");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public Iterable<Questions> getAllQuestion() {
		return questionService.retrieveAllQuestion();
	}
	
	@GetMapping("/{id}")
	public Optional<Questions> getQuestion(@PathVariable("id") long id) {
		return questionService.retreiveQuestion(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable("id") long id ) {
		questionService.deleteQuestion(id);
	}
	
	@PutMapping("{id}")
	public void updateQuestion(@PathVariable("id") long id,@RequestBody Questions question) {
		questionService.updateQuestion(id, question);
	}
	
	@ExceptionHandler(value = { QuestionNotFoundException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<Questions> exception(RuntimeException runtimeException) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
