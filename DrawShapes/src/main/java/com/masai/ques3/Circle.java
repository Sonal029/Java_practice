package com.masai.ques3;

public class Circle implements DrawShape{
@Override
public void draw() {
		System.out.println("You have drawn a Circle");
		tellShape();
	}
public void tellShape()
{
	System.out.println("circle");
}
}
