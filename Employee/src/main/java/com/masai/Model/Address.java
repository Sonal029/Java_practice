package com.masai.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	
	@NotNull(message="Field is mandatory")
	private String state;
	
	@NotNull(message="Field is mandatory")
	private String city;
	
	@NotNull(message="Field is mandatory")
	private String pincode;
}
