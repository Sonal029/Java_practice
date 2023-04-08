package practice.java;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	    public static void main(String[] args)
	    {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter no of tc");
	        int tc =sc.nextInt();
	        for(int j=0;j<tc;j++)
	        {
		        int n=sc.nextInt();
		        int[] arr = new int[n];
		        for(int i=0;i<n;i++)
		        {
		            arr[i]=sc.nextInt();
		        }
		        String ans=cars(n,arr);
		        System.out.println(ans);
		 
	         }
	        sc.close();
	    }
	    
	    public static String cars(int n ,int[] arr)
	    {
	        String ans="";
	        Stack<Integer> stk = new Stack<Integer>();
	        int count=1;
	        for(int i=0;i<n;i++)
	        {
	            while(stk.size()!=0 && stk.peek()<arr[i])
	            {
	                count++;
	                stk.pop();
	            }
	            if(arr[i]==count)
	            {
	                count++;
	            }
	            else if(stk.size()>0 && stk.peek()<arr[i])
	            {
	              ans=("NO");
	            }
	            else
	            {
	                stk.push(arr[i]);
	            }
	        }
	        if(ans=="NO")
	        {
	            return ans;
	        }
	        else
	        {
	          ans=("YES");
	          return ans;
	        }
	        
	        
	    }

}
