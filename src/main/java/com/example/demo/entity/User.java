package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String userId;

	@Column(nullable=false, length=10)
	@NotEmpty
	@Size(min=3,message="name should more than two character")
	private String firstName;
	
	@Column(nullable=false, length=10)
	private String lastName;
	
	@Column(nullable=false, length=20)
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min=8,max=30,message="password should be 8 character")
	private String password;
}
