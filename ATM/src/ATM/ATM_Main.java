package ATM;

import java.util.Scanner;

public class ATM_Main {

	public static void main(String[] args) {
		atm a = new atm();
		a.checkPin();
	}
}

class atm
{
	Scanner sc = new Scanner(System.in);
	float balance;
	int pin = 2134;
	
	
	public void checkPin()
	{
		System.out.println("please enter your 4 digit pin");
		
		int enteredPin = sc.nextInt();
		
		if(enteredPin==pin)
		{
			Menu();
		}
		else
		{
			System.out.println("Invalid pin. please try again");
			checkPin();
		}
	}


	private void Menu() 
	{
		System.out.println("Enter your choice");
		System.out.println("1. Check account balance" );
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Exit");
		
		int choice =sc.nextInt();
		switch(choice)
		{
			case 1:
			{
				checkBalance();
				break;
			}
			case 2:
			{
				withdraw();
				break;
			}
			case 3:
			{
				deposit();
				break;
			}
			case 4:
			{
				Menu();
			}
			default:
			{
				System.out.println("Enter correct choice");
				Menu();
				
			}
		}
		
		
	}


	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Enter amount to be Deposited");
		double amt = sc.nextDouble();
		balance+= amt;
        checkBalance();
	}


	public void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("Enter amount to be withdrawn");
		double amt = sc.nextDouble();
		if(amt>balance)
		{
			System.out.println("Insufficient fund");
		}
		else
		{
			balance-= amt;
	        checkBalance();
		}
	}


	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Balance is "+ balance);
		
		Menu();
	}
	
}

