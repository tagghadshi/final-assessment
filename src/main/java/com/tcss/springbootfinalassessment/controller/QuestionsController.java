package com.tcss.springbootfinalassessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcss.springbootfinalassessment.entity.Questions;
import com.tcss.springbootfinalassessment.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionsController.class);

	QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<Object> saveQuestion(@RequestBody Questions question) {
		questionService.saveQuestion(question);
		logger.debug("Saved in Database");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
