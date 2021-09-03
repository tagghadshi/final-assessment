package com.tcss.springbootfinalassessment.exception;

public class NotValidQuestion extends RuntimeException {
	public NotValidQuestion(String msg ) {
		super(msg);
	}
}
