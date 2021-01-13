package com.dollarsbank.utility;

import java.util.ArrayList;

import com.dollarsbank.model.Customer;

public class FileStorageUtility
{
	private ArrayList<Customer> users = new ArrayList<Customer>();
	private Customer currentUser;

	public FileStorageUtility()
	{
		super();
		currentUser = null;
	}
	
	public void addUser(Customer cust)
	{
		this.users.add(cust);
		this.setCurrentUser(cust);
	}
	
	public boolean login(String userId, String password)
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUserId().equals(userId))
			{
				boolean correctPassword = password == users.get(i).getPassword();
				
				if(correctPassword)
				{
					this.setCurrentUser(users.get(i));
				}
				
				return correctPassword;
			}
		}
		return false;
	}
	
	public void logout()
	{
		setCurrentUser(null);
	}

	public Customer getCurrentUser()
	{
		return currentUser;
	}

	public void setCurrentUser(Customer currentUser)
	{
		this.currentUser = currentUser;
	}
}
