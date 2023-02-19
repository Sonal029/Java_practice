package com.practice;

import java.util.Scanner;

public class ramsonNotes {
   public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("enter length of text1");
	        int n =sc.nextInt();
	        System.out.println("enter length of text2");
	
	        int m =sc.nextInt();
	     
	        System.out.println("EnterRamson text");
	        
	        String ramsonNote = sc.nextLine();
	         
	        System.out.println("enter Magazine");
	        
	        
	        String magazine = sc.nextLine();
	        
	        boolean ans = canConstruct(ramsonNote,magazine);
	        if(ans)
	        {
	            System.out.println("Yes");
	        }
	        else
	        {
	            System.out.println("No");
	        }
	   
	        sc.close();
	    }
	    
	    
	    public static boolean canConstruct(String ramsonNote, String magazine)
	    {
	        for(int i=0;i<ramsonNote.length();i++)
	        {
	            char r = ramsonNote.charAt(i);
	            
	            int matchingIndex= magazine.indexOf(r);
	            
	            if(matchingIndex == -1)
	            {
	                return false;
	            }
	            
	            magazine = magazine.substring(0, matchingIndex)+magazine.substring(matchingIndex+1);
	        }
	        
	        return true;
	    }
	}
