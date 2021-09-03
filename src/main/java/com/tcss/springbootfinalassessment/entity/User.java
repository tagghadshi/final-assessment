package com.tcss.springbootfinalassessment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Name is compulsory")
	@NotBlank(message = "Name is compulsory")
	@Size(min = 2, message = "Name should be greater than  2 characters")
	private String name;
	
	@Email
	private String email;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private Questions question;
	
}
