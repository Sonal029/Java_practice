package com.practice;

import java.util.Scanner;
import java.util.Stack;

public class string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of test cases");
		int tc = sc.nextInt();
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < tc; i++) {
			System.out.println("Enter \n1. PUSH \n2. POP \n3.PEEK");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.println("Enter Element");
				int a=sc.nextInt();
				stk.push(a);
				System.out.println(a+"  added sucessfully");
			} else if (n == 2) {
				if (stk.isEmpty()) {
					continue;
				} else {
					stk.pop();
					System.out.println("the poped element is"+stk.pop());
				}
			} else if (n == 3) {
				if (stk.isEmpty()) {
					System.out.println("Empty!");
				} else {
					System.out.println("The peeked element is \t"+stk.peek());
				}
			}
		}
	}
}
