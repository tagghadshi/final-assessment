package com.tcss.springbootfinalassessment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Question is compulsory")
	@NotBlank(message = "Question is compulsory")
	@Size(min = 2, message = "Question should be greater than  2 characters")
	private String question;
	
	private int votes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	@JsonIgnoreProperties("question")
	private User user;
}
