package com.court.UI;

import java.util.Scanner;

import com.court.Exception.SomethingWentWrongException;

public class UIMain 
{
    public static void main(String[] args) throws SomethingWentWrongException 
    {
    	while(true)
    	{
	    	Scanner sc = new Scanner(System.in);
			System.out.println("Enter the operation which you want to perform");
			System.out.println("0. Exit");
			System.out.println("1. Add new lawyer");
			System.out.println("2. Update lawyer details");
			System.out.println("3. View Lawyer List");
			System.out.println("4. Delete lawyer");
			
			
			int ch = sc.nextInt();
			if(ch==1)
			{
				UILawyer.addLawyer(sc);
			}
			else if(ch==2)
			{
				UILawyer.updateLawyer(sc);
			}
			else if(ch==3)
			{
				UILawyer.viewLawyer();
			}
			else if(ch==4)
			{
				UILawyer.deleteLawyer(sc);
			}
			else if(ch==0)
			{
				System.out.println("Thank you !!");
				break;
			}
			else
			{
				System.out.println("Invalid choice try again");
			}
    	}
	}
}
