package q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.masai.Employee;

public class Driver implements Comparator {

	public static void main(String[] args)
	{
		List<Product> al = new ArrayList<Product>();
		al.add(new Product(1,"Shoes",1,1299));
		al.add(new Product(2,"Dress",1,2599));
		al.add(new Product(3 ,"Books",1,1000));
		al.add(new Product(4,"T-shirt",1,700));
		al.add(new Product(5,"Flowers",1,300));
		
		Comparator<Product> comp= (s1,s2)->
	    {
	    	if(s1.getPrice()>s2.getPrice())
	    		return -1;
	    	else 
	    		return 1;

	    };
		Collections.sort(al, comp);
		System.out.println(al);
	}
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
	}

}
