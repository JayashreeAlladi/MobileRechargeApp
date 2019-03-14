 package com.mra.ui;

import java.util.Scanner;

import com.mra.beans.Account;
import com.mra.dao.AccountDao;
import com.mra.dao.AccountDaoImpl;
import com.mra.service.AccountService;
import com.mra.service.AccountServiceImpl;

public class MobileApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AccountService as = new AccountServiceImpl();
		while(true)
		{
			System.out.println("====Mobile Recharge====");
			System.out.println("1.Account Enquiry\n 2.Recharge \n 3.Exit");
			int n = sc.nextInt();
			switch(n)
			{
			case 1: System.out.println("Enter the mobile no");
					String mobileNo = sc.next();
					
					Account a = as.getAccountDetails(mobileNo);
					if(a != null)
						System.out.println("Your Current Balance is "+a.getAccountBalance());
					else
						System.out.println("Account id doesn't exists");
			       break;
			case 2: System.out.println("Enter MobileNo:");
					String mobileNum = sc.next();
	
					Account a1 = as.getAccountDetails(mobileNum);
					if(a1 != null)
					{
						System.out.println("Enter Recharge Amount:");
						int amount = sc.nextInt();
						int balance = as.rechargeAccount(mobileNum, amount);
						System.out.println("Your Account Recharged Successfully");
						System.out.println("Hello your"+"Available Balance is "+balance);
					}
					else
					{
						System.out.println("Cannot Recharge Mobile No Does Not Exists");
					}
					break;
			case 3: System.out.println("Thank You");
					System.exit(0);
			}
		}	
	}
}
