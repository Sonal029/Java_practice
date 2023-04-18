package models;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="get coffee By id" , query = "Select c from coffee c where c.coffeeId :coffeeId and c.rating >=4")
public class Coffee extends Beverage
{

	private int coffeeId ;
	private double price;
	private String description;
	private String origin;
	public Coffee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coffee(int coffeeId, double price, String description, String origin) {
		super();
		this.coffeeId = coffeeId;
		this.price = price;
		this.description = description;
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Coffee [coffeeId=" + coffeeId + ", price=" + price + ", description=" + description + ", origin="
				+ origin + "]";
	}
	public int getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}




}
