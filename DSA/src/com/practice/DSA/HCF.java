package com.practice.DSA;

import java.util.Scanner;

public class HCF 
{
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First number");
		int a =sc.nextInt();
		System.out.println("Enter Second number");
		int b =sc.nextInt();
		int min = Math.min(a,b);
		int max=0;
		for(int i=1;i<=min;i++)
		{
			if(a%i==0 && b%i==0)
			{
				max=Math.max(i, max);
			}
		}
		System.out.println("HCF is: "+max);
	}
}
