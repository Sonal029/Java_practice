package com.practice;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
	
	    public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter no of test cases");
	        int tc = sc.nextInt();
	        for(int t=0;t<tc;t++)
	        {
	            Stack<Integer> stk = new Stack<Integer>();
	            Stack<Integer> ans = new Stack<Integer>();
	            System.out.println("Enter length");
	            int n = sc.nextInt();
	            int[] arr = new int[n];
	            System.out.println("Enter elements");
	            for(int i=0;i<n;i++)
	            {
	                arr[i]=sc.nextInt();
	            }
	            
	            for(int i=n-1;i>=0;i--)
	            {
	                while(!stk.isEmpty() && stk.peek()<=arr[i])
	                {
	                    stk.pop();
	                }
	                
	                if(stk.isEmpty())
	                {
	                    ans.push(-1);
	                }
	                else
	                {
	                    ans.push(stk.peek());
	                }
	                stk.push(arr[i]);
	            }
	            for(int i=0;i<n;i++)
	            {
	                System.out.print(ans.pop()+" ");
	            }
	          System.out.println();  
	        }
	    }
	}
