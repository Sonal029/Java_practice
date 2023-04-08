package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.MobileDao;
import com.masai.dao.MobileDaoImpl;
import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class UIMain {
	
	public static void addMobile(Scanner sc)
	{
		System.out.println("Enter Model No.");
		String model = sc.next();
		
		System.out.println("Enter Comapny Name");
		String company = sc.next();
		
		System.out.println("Enter Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Manufacturing Date");
		LocalDate mfgDate= LocalDate.parse(sc.next());
		
		Mobile mob = new MobileImpl(model,company,price,mfgDate);
		
		MobileDao mobdao = new MobileDaoImpl();
		try {
			mobdao.addMobile(mob);	
			System.out.println("Mobile data added successfully");
		}catch(com.masai.exception.SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	public static void updateMobile(Scanner sc)
	{
		System.out.println("Enter Model No.");
		String model = sc.next();
		
		System.out.println("Enter Comapny Name");
		String company = sc.next();
		
		System.out.println("Enter Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Manufacturing Date");
		LocalDate mfgDate= LocalDate.parse(sc.next());
		
		Mobile mob = new MobileImpl(model,company,price,mfgDate);
		MobileDao mobdao = new MobileDaoImpl();
		try {
			mobdao.updateMobile(mob);	
			System.out.println("Mobile data updated successfully");
		}catch(com.masai.exception.SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}

	
	public static void DeleteMobile(Scanner sc)
	{
		System.out.println("Enter Model No.");
		String model = sc.next();
		
		MobileDao mob = new MobileDaoImpl();
		try {
			mob.DeleteMobile(model);
			System.out.println("Mobile data deleted successfully");	
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public static void SearchByModel(Scanner sc) throws SomethingWentWrongException
	{
		System.out.println("Enter Model No.");
		String model = sc.next();
		
		MobileDao mob = new MobileDaoImpl();
		try {
			List<Mobile> list = mob.SearchByModel(model);
			Consumer<Mobile> con = mobile -> System.out.println("Model no " + mobile.getModel() + " Company " + mobile.getCompany() 
			+ " Price " + mobile.getPrice() + " Manufactured Date " + mobile.getMfgDate());
			list.forEach(con);
		}catch(NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public static void SearchByPrice(Scanner sc) throws SomethingWentWrongException
	{
		System.out.println("Enter lower price limit");
		int lower_price = sc.nextInt();
		System.out.println("Enter higher price limit");
		int higher_price = sc.nextInt();
		
		MobileDao mob = new MobileDaoImpl();
		try {
			List<Mobile> list = mob.SearchByPrice(lower_price , higher_price);
			Consumer<Mobile> con = mobile -> System.out.println("Model no " + mobile.getModel() + " Company " + mobile.getCompany() 
			+ " Price " + mobile.getPrice() + " Manufactured Date " + mobile.getMfgDate());
			list.forEach(con);
		}catch(NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) throws SomethingWentWrongException 
	{
		int choice =0;
		
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println("Enter choice");
			System.out.println("0. Exit");
			System.out.println("1. Add mobiles");
			System.out.println("2. Update details");
			System.out.println("3. Delete details");
			System.out.println("4. Search by Model no");
			System.out.println("5. Search by Price Range");
			
			choice = sc.nextInt();
	
			
			switch(choice)
			{
			case 1:
    			addMobile(sc);
				break;
				
			case 2:
         		updateMobile(sc);
				break;
			case 3:
				DeleteMobile(sc);
				break;
				
			case 4:
				
					SearchByModel(sc);
				
				break;
			case 5:
				SearchByPrice(sc);
				break;
				
			case 0:
				System.out.println("Thanks for coming");
				break;
			
			default:
				System.out.println("Invalid entry try again");
					
			}
			
		}
		while(choice!=0);
		sc.close();
		
		
	}
}
