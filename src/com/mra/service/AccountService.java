package com.mra.service;

import com.mra.beans.Account;

public interface AccountService {
   
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);
}
