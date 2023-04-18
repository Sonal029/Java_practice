package testCase;

import java.util.List;

import dao.DAO;
import dao.DAOImpl;
import models.Coffee;
import models.Tea;

public class Driver 
{

	public static void main(String[] args) {
		
		
		DAO dao = new DAOImpl();
		
		Coffee coffee1 = new Coffee();
		coffee1.setBeverageId(1);
		coffee1.setRating(4.5);
		coffee1.setCoffeeId(1);
		coffee1.setDescription("Brewer");
		coffee1.setOrigin("Malayasia");
		coffee1.setPrice(350.00);
		
		dao.addCoffee(coffee1);
		
		Coffee coffee2 = new Coffee();
		coffee2.setBeverageId(2);
		coffee2.setRating(4.6);
		coffee2.setCoffeeId(2);
		coffee2.setDescription("Mocha");
		coffee2.setOrigin("Bhutan");
		coffee2.setPrice(250.00);
		dao.addCoffee(coffee2);
		
		
		Coffee coffee3 = new Coffee();
		coffee3.setBeverageId(3);
		coffee3.setRating(4.3);
		coffee3.setCoffeeId(3);
		coffee3.setDescription("Coffee3");
		coffee3.setOrigin("Japan");
		coffee3.setPrice(450.00);
		
		dao.addCoffee(coffee3);
		
		Coffee coffee4 = new Coffee();
		coffee4.setBeverageId(4);
		coffee4.setRating(4.8);
		coffee4.setCoffeeId(4);
		coffee4.setDescription("Capachinno");
		coffee4.setOrigin("China");
		coffee4.setPrice(150.00);
		
		dao.addCoffee(coffee4);
		Tea tea1 = new Tea();
		tea1.setBeverageId(5);
		tea1.setRating(5);
		tea1.setTeaId(1);
		tea1.setDescription("black");
		tea1.setFlavor("Masala");
		tea1.setPrice(10.00);
		
		dao.addTea(tea1);
		
		Tea tea2 = new Tea();
		tea2.setBeverageId(6);
		tea2.setRating(5);
		tea2.setTeaId(1);
		tea2.setDescription("Normal");
		tea2.setFlavor("Pan");
		tea2.setPrice(10.00);
		
		dao.addTea(tea2);
		
		Tea tea3 = new Tea();
		tea3.setBeverageId(5);
		tea3.setRating(5);
		tea3.setTeaId(1);
		tea3.setDescription("Normal");
		tea3.setFlavor("Masala");
		tea3.setPrice(60.00);
		
		dao.addTea(tea3);
		
		Tea tea4 = new Tea();
		tea4.setBeverageId(5);
		tea4.setRating(5);
		tea4.setTeaId(1);
		tea4.setDescription("brown");
		tea4.setFlavor("Rose");
		tea4.setPrice(100.00);
		
		dao.addTea(tea4);
		
		
		List<Tea> co = dao.findTeaByFlavour("Masala");
		for(Tea c : co)
		{
			System.out.println(c);
		}
		
		List<Tea> t2 = dao.findTeaById(1);
		for(Tea c : t2)
		{
			System.out.println(c);
		}
		List<Tea> t3 = dao.findTeaByPrice();
		for(Tea c : t3)
		{
			System.out.println(c);
		}
		
		
	}

}
