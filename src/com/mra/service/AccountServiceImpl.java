package com.mra.service;

import com.mra.beans.Account;
import com.mra.dao.AccountDao;
import com.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
	AccountDao ad = new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo) {
		
		Account a = ad.getAccountDetails(mobileNo);
		return a;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		
		int balance = ad.rechargeAccount(mobileNo, rechargeAmount);
		
		return balance;
	}

       
}
