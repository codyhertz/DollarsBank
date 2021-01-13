package com.dollarsbank.controller;

import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankController
{
	public DollarsBankController()
	{
		super();
	}
	
	public void addUser(String name, String address, String number, String userId, String password, double initialDeposit, FileStorageUtility storage)
	{
		Customer cust = new Customer(name, address, number, userId, password, initialDeposit);
		storage.addUser(cust);
	}
	
	public void checkUserBalance(Customer cust)
	{
		cust.checkBalance();
	}
	
	public void checkUserTransactions(Customer cust)
	{
		cust.getTransactions();
	}
	
	public void depositUserChecking(Customer cust, double amount)
	{
		cust.depositChecking(amount);
	}
	
	public void depositUserSavings(Customer cust, double amount)
	{
		cust.depositSavings(amount);
	}
	
	public void withdrawlUserChecking(Customer cust, double amount)
	{
		cust.withdrawlChecking(amount);
	}
	
	public void withdrawlUserSavings(Customer cust, double amount)
	{
		cust.withdrawlSavings(amount);
	}
	
	public void userTransfer(Customer cust, boolean checkingToSavings, double amount)
	{
		cust.transfer(checkingToSavings, amount);
	}
}
