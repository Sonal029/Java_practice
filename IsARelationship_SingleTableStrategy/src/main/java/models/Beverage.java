package models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Beverage_type", discriminatorType = DiscriminatorType.INTEGER)
public class  Beverage
{
     private int beverageId;
     private double rating;
	public Beverage(int beverageId, double rating) {
		super();
		this.beverageId = beverageId;
		this.rating = rating;
	}
	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(int beverageId) {
		this.beverageId = beverageId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
     
     
     
}
