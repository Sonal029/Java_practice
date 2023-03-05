package com.practice;

import java.util.Scanner;

public class MarksCompetition 

{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++)
        {
        	System.out.println("Enter elements");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
           int c=0;
           for(int j=i+1;j<n;j++)
           {
              
               if(arr[i]>=arr[j])
               {
                   continue;
               }
               else
               {
                   c=c+1;
                   break;
               }
           }
           if(c==0)
           {
               str.append(arr[i]+" ");
           }
        }
        System.out.print(str);
    }
}
