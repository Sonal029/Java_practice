package dao;


import java.util.List;

import models.Coffee;
import models.Tea;

public interface DAO {
	
	public void addTea(Tea tea);
	public void addCoffee(Coffee coffee);
	
	
	public List<Coffee> findCoffee(int coffeeId);
	public List<Coffee> findCoffeeByOrigin(String origin);

}
