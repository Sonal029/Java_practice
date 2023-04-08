package com.masai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tester implements Comparator{

	public static void main(String[] args)
	{
		List<Employee> al = new ArrayList<>();
		al.add(new Employee(1 , "Anand", "Delhi",10000));
		al.add(new Employee(2 , "Manish", "Delhi",1000));
		al.add(new Employee(3 , "Alok", "Delhi",120000));
		al.add(new Employee(4 , "Sourav", "Delhi",1300));
		al.add(new Employee(5 , "Sonal", "Delhi",14000));
		al.add(new Employee(6 , "Anshuli", "Delhi",1500));
		al.add( new Employee(7 , "Shashi", "Delhi",160000));
		al.add( new Employee(8 , "Gyan", "Delhi",170000));
		al.add( new Employee(9 , "Shakambhari", "Delhi",18000));
		al.add( new Employee(10 , "Ram", "Delhi",190));

	
	Comparator<Employee> comp = (e1,e2)->
	{
		if(e1.getSalary()<5000)
		{
			return (e1.getSalary()+1000);
		}
		return e1.getSalary();
	};
	
	Collections.sort(al , comp);
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

