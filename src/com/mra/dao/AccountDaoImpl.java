package com.mra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mra.ui.DataConnection;
import com.mra.beans.Account;
import com.mra.ui.MobileApplication;

public class AccountDaoImpl implements AccountDao{
//===========================USING COLLECTION====================================================
  /*  Map<String,Account> accountEntry;
	
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	accountEntry = new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid","Vaishali",200));
		accountEntry.put("9823920123", new Account("Prepaid","Megha",453));
		accountEntry.put("9932012345", new Account("Prepaid","Vikas",631));
		accountEntry.put("9010210132", new Account("Prepaid","Anju",521));
		accountEntry.put("9010210133", new Account("Prepaid","Tushar",632));

	}

@Override
public Account getAccountDetails(String mobileNo) {
	// TODO Auto-generated method stub
	Account user = null; 
	for(Map.Entry<String, Account> m : accountEntry.entrySet())
	{
		if(m.getKey().equals(mobileNo))
		{
			user = m.getValue();
		}
	}
	
	return user;
}

@Override
public int rechargeAccount(String mobileNo, double rechargeAmount) {
	// TODO Auto-generated method stub
	Account user = null;
	
	for(Map.Entry<String, Account> m : accountEntry.entrySet())
	{
		if(m.getKey().equals(mobileNo))
		{
			user = m.getValue();
		
		}
	}
	if(user != null)
	{
		rechargeAmount = rechargeAmount+user.getAccountBalance();
		user.setAccountBalance(rechargeAmount);
		accountEntry.put(mobileNo, user);
	}
	
	return (int)rechargeAmount;
}*/
	
	
	
	
//==============================USING JDBC=======================================================	
	DataConnection d=new DataConnection();
	Account user = new Account();
	@Override
	public Account getAccountDetails(String mobileNo) {
		// TODO Auto-generated method stub
		
		Connection connection=d.connect();
		ResultSet resultSet=null;
		try {
			 Statement statement = connection.createStatement();
			 resultSet=statement.executeQuery("select * from userdetails");
			while(resultSet.next()) {
				if(mobileNo.equals(resultSet.getString(1))) {
				   //System.out.println(mobileNo);
					//System.out.println(resultSet.getString(1));
					System.out.println(resultSet.getDouble(4));
				     user.setAccountBalance(resultSet.getDouble(4));
				   //System.out.println(user);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
	
		Connection connection=d.connect();
		try {
			 Statement statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from userdetails");
			while(resultSet.next()) {
			 if(mobileNo.equals(resultSet.getString(1))){
					
				 user.setAccountBalance(resultSet.getDouble(4));
				if(user != null)
				{
					rechargeAmount = rechargeAmount+user.getAccountBalance();
					user.setAccountBalance(rechargeAmount);
					
			   PreparedStatement preparedstatement=connection.prepareStatement("update userdetails set accountBalance=? where mobileNo=? ");
				preparedstatement.setDouble(1, rechargeAmount);
				preparedstatement.setString(2, mobileNo);
			   int i=preparedstatement.executeUpdate();
			   if(i==1) {
			    	 System.out.println("successfully updated");
			     }
			     else {
			    	 System.out.println("your balance not updated");
			     }
				}
			  }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int) rechargeAmount;
	}
}
