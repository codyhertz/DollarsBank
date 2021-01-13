package com.dollarsbank.model;

public class CheckingAccount
{
	private double amount;

	public CheckingAccount(double amount)
	{
		super();
		this.amount = amount;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}
}
