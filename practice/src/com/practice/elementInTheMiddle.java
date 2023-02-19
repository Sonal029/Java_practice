package com.practice;

import java.util.Scanner;

public class elementInTheMiddle 

	{
	    public static void main(String[] args)
	    {
	       Scanner sc = new Scanner(System.in);
	       System.out.println("enter no of elements");
	       int n =sc.nextInt();
	       
	       int[] arr = new int[n];
	       System.out.println("enter ele");
	       for(int i=0;i<n;i++)
	       {
	           arr[i]=sc.nextInt();
	       }
	       int ans = -1;
	       boolean flag=false;
           int index = 0;
	       for(int i=0;i<n;i++)
	       {  
	           for(int j=i+1;j<n-1;j++)
	           {
	              if(arr[i]>arr[j])
	              {
	                  flag=false;
	                  break;
	              }
	              else
	              {
	                  flag=true;
	                  index=i;
	              }
	              
	           }
	       
	           if(flag==true)
	           {
	               for(int k=index-1;k>=0;k++)
	               {
	                   if(arr[index]<arr[k])
	                   {
	                       flag=false;
	                       ans=-1;
	                       break;
	                   }
	                   else
	                   {
	                     ans= arr[index];   
	                   }
	               }
	           }
	           }
	       System.out.println(ans);
	    }
	}

