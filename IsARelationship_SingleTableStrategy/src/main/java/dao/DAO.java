package dao;


import java.util.List;

import models.Coffee;
import models.Tea;

public interface DAO {
	
	public void addTea(Tea tea);
	public void addCoffee(Coffee coffee);
	
	
	/*
	 * 1. Write a JPQL to get all the Tea details sorted by flavor. **[ Points: 0.25 ]**
2. Write a JPQL to get the Tea by its Id and filter those with a rating less than 3. **[ Points: 0.25 ]**
3. Write a JPQL to get all the Tea whose price is less than 100 and have a specific flavor.
	 */
	
	public List<Tea> findTeaByFlavour(String flavor);
	public List<Tea> findTeaById(int teaId);
	public List<Tea> findTeaByPrice();
	

}
