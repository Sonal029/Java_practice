package com.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class date_time 
{
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt =LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
	}
	

}
