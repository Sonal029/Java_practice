package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class oneByThreeMajority {

		public static void main(String[] args) 
		{
	     Scanner sc= new Scanner(System.in);
	        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        System.out.println("Enter no of elements");
	        int n = sc.nextInt();
	         int[] arr = new int[n];
	         System.out.println("enter elements");
	         for(int i=0;i<n;i++)
	         {
	        	 arr[i]=sc.nextInt();
	         }
	          sc.close();
	          
	          for(int i : arr)
	          {
	        	  if (map.containsKey(i)) {
	        		  
	                 
	                  map.put(i, map.get(i) + 1);
	              }
	              else {
	   
	                  // If character is not present
	                  // in map putting this
	                  // character into map with
	                  // 1 as it's value.
	                  map.put(i, 1);
	              }
	          }
	   
	          int ans=0;
	          for (Entry<Integer, Integer> entry :
	              map.entrySet()) {
	  
	             if (entry.getValue() > n/3) {
	                 ans=(entry.getKey());
	                 break;
	             }
	         }
	          
	          if(ans==0)
	          {
	        	  System.out.println(-1);
	          }
	          else
	          {
	        	  System.out.println(ans);
	          }
		}

	}
