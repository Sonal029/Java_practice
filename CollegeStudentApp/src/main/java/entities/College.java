package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer collegeId;
	private String collegeName;
	private String collegeAddress;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
}
