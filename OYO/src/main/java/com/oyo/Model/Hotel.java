package com.oyo.Model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
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
public class Hotel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer hotelId;
	
	@NotNull(message="Field is mandatory")
	 private String name;
	
	@NotNull(message="Field is mandatory")
	 private String city;
	
	
	@NotNull(message="Field is mandatory")
	 private String address; 
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	 private List<RoomType> list;
}
