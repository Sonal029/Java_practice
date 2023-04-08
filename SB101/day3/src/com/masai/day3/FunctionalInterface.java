package com.masai.day3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

		public static void main(String[] args) {
//			String s = "Masai";
			try {
				System.out.println(10/0);
				int arr[] = {1,2,3,4,5};
				System.out.println(arr[10]);
				
				
			}catch(ArrayIndexOutOfBoundsException | ArithmeticException  ex) {
//				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
			
			Predicate<Integer> p1 = i -> i>10;
			System.err.println(p1.test(20));
			
			
			Consumer<Integer>  c1 = (i) -> System.out.println(i);
			c1.accept(5);
			
			
			Supplier<String> s1 = () -> "Hello";
			System.out.println(s1.get());
			
			Function<Integer,String> f1 = (i) -> i>10 ? "Greater" : "Smaller";
			System.out.println(f1.apply(11));
			
			

		}

	}
