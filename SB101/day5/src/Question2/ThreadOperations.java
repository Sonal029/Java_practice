package Question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThreadOperations{

	static void reverseArray()
	{
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		for(int i=0;i<10;i++)
		{
			System.out.println("Enter Elements to reverse");
			arr[i]= sc.nextInt();
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("Swapping "+arr[i]+", "+arr[9-i]);
			int temp = arr[i];
			arr[i]=arr[9-i];
			arr[9-i]=temp;
		}
		for(int i=0;i<10;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
       void findNearestToAverage()
	{
		List<Integer> al = Arrays.asList(3,4,5,7,14,52,89,60,56,78);
		
		double avg= al.stream().collect(Collectors.averagingDouble(i -> i));
		int diff = Integer.MAX_VALUE;
		int near = al.get(0);
		for(int i:al)
		{
			diff=(int)Math.abs(i-avg);
			near =i;
		}
		System.out.println("Average is "+avg+" The nearest element is "+near);
		
	};
	
}
	
	


