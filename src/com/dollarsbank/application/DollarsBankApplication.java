package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.FileStorageUtility;
import com.dollarsbank.utility.ColorsUtility;

public class DollarsBankApplication
{	
	public static boolean validPassword(String password)
	{
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String special = "!@#$%^&*()-+";
		
		boolean containsLowerCase = false;
		
		for(int i = 0; i < lowerCase.length(); i++)
		{
			if(password.indexOf(lowerCase.charAt(i)) != -1)
			{
				containsLowerCase = true;
				break;
			}
		}
		
		if(!containsLowerCase)
		{
			return false;
		}
		
		boolean containsUpperCase = false;
		
		for(int i = 0; i < upperCase.length(); i++)
		{
			if(password.indexOf(upperCase.charAt(i)) != -1)
			{
				containsUpperCase = true;
				break;
			}
		}
		
		if(!containsUpperCase)
		{
			return false;
		}
		
		boolean containsSpecial = false;
		
		for(int i = 0; i < special.length(); i++)
		{
			if(password.indexOf(special.charAt(i)) != -1)
			{
				containsSpecial = true;
				break;
			}
		}
		
		if(!containsSpecial)
		{
			return false;
		}
		
		if(password.length() < 8)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		FileStorageUtility storage = new FileStorageUtility();
		DollarsBankController dbc = new DollarsBankController();
		
		Scanner scanny = new Scanner(System.in);
		int choice = 0;
		boolean exit = false;
		
		do
		{
			if(storage.getCurrentUser() == null)
			{
				System.out.println(ColorsUtility.ANSI_CYAN + "+---------------------------+");
				System.out.println("| DOLLARSBANK WELCOMES YOU! |");
				System.out.println("+---------------------------+" + ColorsUtility.ANSI_RESET);
				System.out.println("1. Create New Account");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Choice (1, 2 or 3):" + ColorsUtility.ANSI_RESET);
				
				choice = scanny.nextInt();
				scanny.nextLine();
				
				switch(choice)
				{
					case 1:
						System.out.println(ColorsUtility.ANSI_CYAN + "+-------------------------------+");
						System.out.println("| ENTER DETAILS FOR NEW ACCOUNT |");
						System.out.println("+-------------------------------+" + ColorsUtility.ANSI_RESET);
						System.out.println("Customer Name:");
						String name = scanny.nextLine();
						System.out.println("Customer Address:");
						String address = scanny.nextLine();
						System.out.println("Customer Contact Number:");
						String number = scanny.nextLine();
						System.out.println("User ID:");
						String id = scanny.nextLine();
						
						boolean valid = false;
						String password = "";
						do
						{
							System.out.println("Password:");
							password = scanny.nextLine();
							
							valid = validPassword(password);
							
							if(!valid)
							{
								System.out.println("Your password is invalid. Please enter a new one.");
							}
						}while(!valid);
						
						System.out.println("Initial Deposit:");
						double initialAmount = scanny.nextDouble();
						scanny.nextLine();
						
						dbc.addUser(name, address, number, id, password, initialAmount, storage);
						
						break;
						
					case 2:
						valid = false;
						do
						{
							System.out.println(ColorsUtility.ANSI_CYAN + "+---------------------+");
							System.out.println("| ENTER Login Details |");
							System.out.println("+---------------------+" + ColorsUtility.ANSI_RESET);
							System.out.println("User ID:");
							id = scanny.nextLine();
							System.out.println("Password:");
							password = scanny.nextLine();
							
							valid = storage.login(id, password);
							
							if(!valid)
							{
								System.out.println("Invalid Credentials. Try Again!");
							}
							
						}while(!valid);
						break;
					case 3:
						exit = true;
						break;						
				}
			}
			else
			{
				do
				{
					System.out.println(ColorsUtility.ANSI_CYAN + "+---------------------+");
					System.out.println("| Welcome Customer!!! |");
					System.out.println("+---------------------+" + ColorsUtility.ANSI_RESET);
					System.out.println("1. Deposit Amount Checking");
					System.out.println("2. Deposit Amount Savings");
					System.out.println("3. Withdraw Amount Checking");
					System.out.println("4. Withdraw Amount Savings");
					System.out.println("5. Transfer Between Accounts");
					System.out.println("6. View 5 Recent Transactions");
					System.out.println("7. Display Customer Information");
					System.out.println("8. Sign Out");
					
					System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Choice (1, 2, 3, 4, 5, 6, 7, or 8):" + ColorsUtility.ANSI_RESET);
					
					choice = scanny.nextInt();
					scanny.nextLine();
					
					switch(choice)
					{
						case 1:
							System.out.println(ColorsUtility.ANSI_CYAN + "+------------------+");
							System.out.println("| Deposit Checking |");
							System.out.println("+------------------+" + ColorsUtility.ANSI_RESET);
							System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
							double amount = scanny.nextDouble();
							scanny.nextLine();
							dbc.depositUserChecking(storage.getCurrentUser(), amount);
							break;
						case 2:
							System.out.println(ColorsUtility.ANSI_CYAN + "+-----------------+");
							System.out.println("| Deposit Savings |");
							System.out.println("+-----------------+" + ColorsUtility.ANSI_RESET);
							System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
							amount = scanny.nextDouble();
							scanny.nextLine();
							dbc.depositUserSavings(storage.getCurrentUser(), amount);
							break;
						case 3:
							System.out.println(ColorsUtility.ANSI_CYAN + "+-------------------+");
							System.out.println("| Withdraw Checking |");
							System.out.println("+-------------------+" + ColorsUtility.ANSI_RESET);
							System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
							amount = scanny.nextDouble();
							scanny.nextLine();
							dbc.withdrawlUserChecking(storage.getCurrentUser(), amount);
							break;
						case 4:
							System.out.println(ColorsUtility.ANSI_CYAN + "+------------------+");
							System.out.println("| Withdraw Savings |");
							System.out.println("+------------------+" + ColorsUtility.ANSI_RESET);
							System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
							amount = scanny.nextDouble();
							scanny.nextLine();
							dbc.withdrawlUserSavings(storage.getCurrentUser(), amount);
							break;
						case 5:
							System.out.println(ColorsUtility.ANSI_CYAN + "+----------------+");
							System.out.println("| Transfer Money |");
							System.out.println("+----------------+" + ColorsUtility.ANSI_RESET);
							System.out.println("1. Checking to Savings");
							System.out.println("2. Savings to Checking");
							
							System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Choice (1 or 2):" + ColorsUtility.ANSI_RESET);
							
							choice = scanny.nextInt();
							scanny.nextLine();
							
							if(choice == 1)
							{
								System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
								amount = scanny.nextDouble();
								scanny.nextLine();
								dbc.userTransfer(storage.getCurrentUser(), true, amount);
							}
							else if(choice == 2)
							{
								System.out.println(ColorsUtility.ANSI_GREEN + "\nEnter Amount:" + ColorsUtility.ANSI_RESET);
								amount = scanny.nextDouble();
								scanny.nextLine();
								dbc.userTransfer(storage.getCurrentUser(), false, amount);
								
							}
							
							break;
						case 6:
							System.out.println(ColorsUtility.ANSI_CYAN + "+-----------------------+");
							System.out.println("| 5 Recent Transactions |");
							System.out.println("+-----------------------+" + ColorsUtility.ANSI_RESET);
							dbc.checkUserTransactions(storage.getCurrentUser());
							break;
						case 7:
							System.out.println(ColorsUtility.ANSI_CYAN + "+------------------------------+");
							System.out.println("| Display Customer Information |");
							System.out.println("+------------------------------+" + ColorsUtility.ANSI_RESET);
							System.out.println(storage.getCurrentUser());
							break;
						case 8:
							storage.logout();
							break;
					}
				}while(choice != 8);
		
			}
			
		}while(!exit);
	}
}
