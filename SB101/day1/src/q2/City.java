package q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class City
{
	private static final City City = null;
	public static void main(String[] args) {
		 List<String> cities = new ArrayList
				 <String>();
		    cities.add("Mumbai");
		    cities.add("Delhi");
		    cities.add("Bangalore");
		    cities.add("Nagpur");
		    cities.add("Patna");
		    cities.add("Bhagalpur");
		    cities.add("Faridabad");
		    cities.add("Ludhiana");
		    
		  

//	Comparator<String> comp= (s1,s2)->
//    {
//    	
//		return s2.compareTo(s1);
//    	
//    };
	
	Collections.sort(cities, (s1,s2)->s2.compareTo(s1));
		System.out.println(cities);   
}
}
	

		

	
