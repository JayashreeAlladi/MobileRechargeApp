package com.mra.dao;

import com.mra.beans.Account;

public interface AccountDao {
     Account getAccountDetails(String mobileNo);
    int rechargeAccount(String mobileNo, double rechargeAmount);
}
