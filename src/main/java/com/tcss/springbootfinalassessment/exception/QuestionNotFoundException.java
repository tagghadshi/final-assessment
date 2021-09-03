package com.tcss.springbootfinalassessment.exception;

public class QuestionNotFoundException extends RuntimeException {
	public QuestionNotFoundException(String msg) {
		super(msg);
	}
}
