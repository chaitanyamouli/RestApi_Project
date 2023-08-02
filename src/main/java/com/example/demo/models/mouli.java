package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class mouli {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="Username",nullable = false,length=10)
	private String name;
	@Email
	private String email;
	@Pattern(regexp =   "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length = 16)
	@Size(min = 6,max = 16)
	private String password;
			
	

}
