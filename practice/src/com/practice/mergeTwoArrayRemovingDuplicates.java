package com.practice;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class mergeTwoArrayRemovingDuplicates {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter no of test cases");
		int tc = sc.nextInt();
		for(int t=0;t<tc;t++)
		{
		System.out.println("Enter no of elements of first array");
		
		int n = sc.nextInt();
		
		Set<Integer> set = new TreeSet<>();
		System.out.println("Enter elements of first array");
		for(int i=0;i<n;i++)
		{
			set.add(sc.nextInt());
		}
		System.out.println("Enter no of elements of second array");
		int m = sc.nextInt();
		System.out.println("Enter elements of second array");
		for(int i=0;i<m;i++)
		{
			set.add(sc.nextInt());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Integer i : set)
		{
			sb.append(i+" ");
		}
		
		System.out.println(sb);
	}
	}
	
	

}
