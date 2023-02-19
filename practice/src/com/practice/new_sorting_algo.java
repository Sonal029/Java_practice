package com.practice;

import java.util.Scanner;

public class new_sorting_algo 
	{
	    public static void main(String[] args)
	    {
	        Scanner sc=new Scanner(System.in);
	        
	        System.out.println("Enter no of elements");
	        int n= sc.nextInt();
	        System.out.println("Enter the no to be divided by");
	        int k =sc.nextInt();
	        System.out.println("Enter elements");
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++)
	        {
	            arr[i]=sc.nextInt();
	        }
	        int[] mod =new int[n];
	        int max=-1;
	        for(int i=0;i<n;i++)
	        {
	            mod[i]=arr[i]%k;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            //  System.out.print(arr[i]+" ");
	            for(int j=0;j<n-1-i;j++)
	            {
	              if(mod[j]>mod[j+1])
	              {
	                  int temp=arr[j];
	                  arr[j]=arr[j+1];
	                  arr[j+1]=temp;
	                  int temp1=mod[j];
	                  mod[j]=mod[j+1];
	                  mod[j+1]=temp1;
	              }
	            }
	        }
	         for(int i=0;i<n;i++)
	        {
	            System.out.print(arr[i]+" ");
	        }
	        
	    }
	}
