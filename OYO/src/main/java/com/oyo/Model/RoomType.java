package com.oyo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
       private Integer roomId;
      
       
       @NotNull(message="Field is mandatory")
       private String name;
       
       @NotNull(message="Field is mandatory")
       private String description;
       
       @NotNull(message="Field is mandatory")
       private Integer capacity;
       
       @NotNull(message="Field is mandatory")
       private Double price; 
       
       @NotNull(message="Field is mandatory")
       private Type type;
       
       @ManyToOne
       @JoinColumn(name="hotelId")
       private Hotel hotel;
       
       @OneToMany(mappedBy = "roomType" , cascade = CascadeType.ALL)
       List<Booking> bookingList;
}


enum Type
{
	SINGLE,DOUBLE,DELUXE,PREMIUM
}
