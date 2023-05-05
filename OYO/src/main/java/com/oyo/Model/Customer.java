package com.oyo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message="Mandatory Field")
	private String firstName;
	
	@NotNull(message="Mandatory Field")
	private String lastName;
	
	@NotNull(message="Mandatory Field")
	@Email(message="This field requires data in email format")
	private String email;
	
	@NotNull(message="Mandatory Field")
	 @Pattern(regexp = "^[6-9]/d{9}$", message = "Invalid mobile number")
	private String phone;
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private List<Booking> BookingList;
}
