package Question4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class master implements Runnable
{
	Country c;

	public master(Country c) {
		super();
		this.c = c;
	}
	
	public void run()
	{
		try {
			c.askCapitalName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class student implements Runnable
{
	Country c = new Country();

	public student(Country c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			c.printCapitalName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class Country {

	
	String countryName=null;
	static Map<String , String> map = new LinkedHashMap<>();
	static {
	map.put("Afghanistan", "Kabul");
	map.put("Belgium", "Brussels");
	map.put("Canada", "Ottawa");
	map.put("Finland", "Helsinki");
	map.put("Greece", "Athens");
	map.put("Hungary", "Budapest");
	map.put("Iraq", "Baghdad");
	map.put("Norway", "Oslo");
	map.put("South Korea", "Seoul");
	}
	
	
	synchronized void askCapitalName() throws InterruptedException
	{
		List<String> al = new ArrayList<>();
		al.addAll(map.keySet());
		
		int index = (int)Math.random()*10%al.size();
		while(!al.isEmpty())
		{
			countryName = al.get(index);
			
			System.out.println("What is  the Capital of "+countryName+" ? ");
			
			al.remove(index);
			notify();
			wait();
		}
		
	     
	}
	
	
	synchronized void printCapitalName() throws InterruptedException
	{
		if(countryName==null)
		{
			wait();
		}
		
		while(!map.isEmpty())
		{
			System.out.println("Capital of "+countryName+" is "+map.get(countryName));
			
			map.remove(countryName);
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		
	}
}

