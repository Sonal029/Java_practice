package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class alan_frequenncy {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the string");
	    String str=sc.nextLine();
	    
	    System.out.println(str);
	    
	    sc.close();
	    countDuplicateCharacters(str);
	    
	}
	public static void
	countDuplicateCharacters(String str)
	{

	    Map<Character, Integer> map
	        = new HashMap<Character, Integer>();

	    char[] charArray = str.toCharArray();

	   
	    for (char c : charArray) {

	        if (map.containsKey(c)) {

	           
	            map.put(c, map.get(c) + 1);
	        }
	        else {

	            
	            map.put(c, 1);
	        }
	    }

	    
	    for (Map.Entry<Character, Integer> entry :
	         map.entrySet()) {
	            System.out.println(entry.getKey()
	                               + " - "
	                               + entry.getValue());
	        }
	    }
	}
	
