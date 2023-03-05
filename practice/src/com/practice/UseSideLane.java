package com.practice;

import java.util.Scanner;
import java.util.Stack;

public class UseSideLane 
{
	    public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter test cases cases ends when ");
	        while(true)
	        {
	        	System.out.println("Enter no of trucks");
	            int n = sc.nextInt();
	            if(n==0)
	            {
	            	System.out.println("no of trucks is 0 so the loop breaks");
	                break;
	            }
	            else
	            
	            {
	                // System.out.println(n);
	               
	                int[] arr = new int[n];
	                System.out.println("Enter order of trucks");
	                 for(int i=0;i<n;i++)
	                {
	                    arr[i]=sc.nextInt();
	                }
	                boolean ans = UseSideLane(n ,arr);
	                if(ans)
	                {
	                    System.out.println("yes");
	                }
	                else
	                {
	                    System.out.println("no");
	                }
	            }
	        }
	    }
	                
	                
	                public static boolean UseSideLane(int n , int[] arr)
	                {
	                     Stack<Integer> stk = new Stack<Integer>();
	                        int expected = 1;
	                        for(int i=0;i<n;i++)
	                        {
	                            while(!stk.isEmpty() && stk.peek()==expected)
	                            {
	                                stk.pop();
	                                expected++;
	                            }
	                            if(arr[i]==expected)
	                            {
	                                expected++;
	                            }
	                            else if(!stk.isEmpty() && arr[i]>stk.peek())
	                            {
	                              return false;
	                               
	                            }
	                            else
	                            {
	                                stk.push(arr[i]);
	                            }
	                            
	                            // System.out.println(stk);
	                    }
	                    return true;
	                }
	}

