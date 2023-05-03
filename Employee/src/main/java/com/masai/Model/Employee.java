package com.masai.Model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Field is mandatory")
	private String firstName ;
	
	@NotNull(message="Field is mandatory")
	private String lastName;
	
	@NotNull(message="Field is mandatory")
	@Email(message="Give correct email address")
	private String email;
	
	@NotNull(message="Field is mandatory")
    @Pattern(regexp = "[6-9]\\d{9}" , message="Give a correct format")
	private String phone;
	
	
	@Embedded
	@NotNull(message="Field is mandatory")
	private Address address;
	
	@NotNull(message="Field is mandatory")
	@Past(message="Date should be of anytime past")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate hireDate;
	
	@NotNull(message="Field is mandatory")
	@Min(value = 10000 , message="Minimum salary should be 10000")
	private Double salary;
	
	@NotNull(message="Field is mandatory")
	private String jobTitle;
	
	@NotNull(message="Field is mandatory")
	private Double sales;
}
