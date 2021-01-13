package com.dollarsbank.model;

import java.util.ArrayList;

public class Customer
{
	private String name;
	private String address;
	private String number;
	private String userId;
	private String password;
	private ArrayList<String> transactions = new ArrayList<String>();
	private SavingsAccount savings = new SavingsAccount(0);
	private CheckingAccount checking = new CheckingAccount(0);
	
	public Customer(String name, String address, String number, String userId, String password, double initialDeposit)
	{
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.userId = userId;
		this.password = password;
		this.checking.setAmount(initialDeposit);
		
		this.transactions.add(name + " deposited $" + Double.toString(initialDeposit) + " into their checking account.");
	}
	
	public void checkBalance()
	{
		System.out.println("Checking: $" + this.checking.getAmount() + "\nSavings: $" + this.savings.getAmount());
	}
	
	public void depositChecking(double amount)
	{
		this.checking.setAmount(this.checking.getAmount() + amount);
		this.transactions.add(this.name + " deposited $" + Double.toString(amount) + " into their checking account.");
	}
	
	public void depositSavings(double amount)
	{
		this.savings.setAmount(this.savings.getAmount() + amount);
		this.transactions.add(this.name + " deposited $" + Double.toString(amount) + " into their savings account.");
	}
	
	public void withdrawlChecking(double amount)
	{
		if(amount <= this.checking.getAmount())
		{
			this.checking.setAmount(this.checking.getAmount() - amount);
			this.transactions.add(this.name + " withdrew $" + Double.toString(amount) + " from their checking account.");
		}
		else
		{
			System.out.println("Invalid funds!");
		}
	}
	
	public void withdrawlSavings(double amount)
	{
		if(amount <= this.savings.getAmount())
		{
			this.savings.setAmount(this.savings.getAmount() - amount);
			this.transactions.add(this.name + " withdrew $" + Double.toString(amount) + " from their savings account.");
		}
		else
		{
			System.out.println("Invalid funds!");
		}
	}
	
	public void transfer(boolean checkingToSavings, double amount)
	{
		if(checkingToSavings)
		{
			if(amount > this.checking.getAmount())
			{
				this.checking.setAmount(this.checking.getAmount() - amount);
				this.savings.setAmount(this.savings.getAmount() + amount);
				
				this.transactions.add(this.name + " transferred $" + Double.toString(amount) + " from their checking account to their savings account.");
			}
			else
			{
				System.out.println("Invalid funds!");
			}
		}
		else
		{
			if(amount > this.savings.getAmount())
			{
				this.savings.setAmount(this.savings.getAmount() - amount);
				this.checking.setAmount(this.checking.getAmount() + amount);
				
				this.transactions.add(this.name + " transferred $" + Double.toString(amount) + " from their savings account to their checking account.");
			}
			else
			{
				System.out.println("Invalid funds!");
			}
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void getTransactions()
	{
		if(this.transactions.size() > 5)
		{
			for(int i = 0; i < 5; i++)
			{
				System.out.println(this.transactions.get(i));
			}
			checkBalance();
		}
		else
		{
			for(int i = 0; i < this.transactions.size(); i++)
			{
				System.out.println(this.transactions.get(i));
			}
			checkBalance();
		}
	}
	
	
	
}
