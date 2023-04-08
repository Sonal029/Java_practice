package com.court.UI;

import java.util.List;
import java.util.Scanner;

import com.court.DAO.LawyerDAO;
import com.court.DAO.LawyerDAOImpl;
import com.court.DTO.Lawyer;
import com.court.DTO.LawyerImpl;
import com.court.Exception.SomethingWentWrongException;

public class UILawyer {
	
	public static void addLawyer(Scanner sc) throws SomethingWentWrongException 
	{
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		
		System.out.println("Enter Name");
		String name=sc.next();
		
		
		System.out.println("Enter email");
		String email=sc.next();
		
		
		sc.nextLine();
		
		System.out.println("Enter Address");
		String address =sc.nextLine();
		
		
		System.out.println("Enter years of experience");
		int exp=sc.nextInt();
		
		Lawyer l = new LawyerImpl(id,name,email,address,exp);
		
		LawyerDAO ldao = new LawyerDAOImpl();
		ldao.addLAwyer(l);
		System.out.println("Lawyer details added sucessfully");
	}

	public static void updateLawyer(Scanner sc) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		
		System.out.println("Enter Name");
		String name=sc.next();
		
		
		System.out.println("Enter email");
		String email=sc.next();
		
		
		sc.nextLine();
		
		System.out.println("Enter Address");
		String address =sc.nextLine();
		
		
		System.out.println("Enter years of experience");
		int exp=sc.nextInt();
		
		Lawyer l = new LawyerImpl(id,name,email,address,exp);
		LawyerDAO ldao = new LawyerDAOImpl();
		ldao.updateLAwyer(l);
		System.out.println("Lawyer details updated sucessfully");
		
	}

	public static void deleteLawyer(Scanner sc) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter Id of lawyer whose details is to be deleted");
		int id = sc.nextInt();
		LawyerDAO ldao = new LawyerDAOImpl();
		ldao.deleteLAwyer(id);
		System.out.println("Lawyer details deleted sucessfully");
		
	}

	public static void viewLawyer() throws SomethingWentWrongException 
	{
		LawyerDAO ldao = new LawyerDAOImpl();
       	List<Lawyer> list = ldao.viewLawyer();
       	
       	list.forEach(System.out::println);
	}

}
