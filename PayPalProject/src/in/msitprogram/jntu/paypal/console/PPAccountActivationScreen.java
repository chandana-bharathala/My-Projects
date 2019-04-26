package in.msitprogram.jntu.paypal.console;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

import java.io.Serializable;
import java.util.Scanner;

public class PPAccountActivationScreen implements Serializable {
	
	public static void show() throws Exception {
		
		String email;//change to get console input
		String password;
		int a;
		Scanner sc =new Scanner(System.in);
		System.out.println("enter your registered email");
		email=sc.next();
		System.out.println("enter your password");
		password=sc.next();
		
		/*
		 * TODO
		 * fetch the account object using email address
		 * check if the account is suspended
		 * if suspended then activate it
		 * if activation code invalid, retry for 2 more attempts
		 * on successful activation show main menu
		 * on failure show the error message and continue to main menu
		 */				
		
		PPAccount account = DataStore.lookupAccount(email, password);
		
		//check if account is active. if yes then ask for suspending it
		
		// if yes suspend it if not go back to main menu
		
		// accept activation code, check if valid, if not give 2 more attempts
		
		//proceed to main menu
		System.out.println("1. Suspend your account\n"+"2. activate your account");
		a=sc.nextInt();
		switch(a)
		{
		case 1: if(account!=null)
				{
					if(account.isActivated())
					{
						account.suspend();
					}
					else
					{
						System.out.println("your account is already suspended");
						MainMenu.show();
					}
				}
				break;
		case 2:	
				String str=PPToolkit.generateActivationCode();
				System.out.println("**"+str+"**");
				for(int i=0;i<3;i++)
					{	
						System.out.println("enter the activation code you have recieved");
						String str1=sc.next();
						if(str.equals(str1))
							{
								System.out.println("your account has been activated");
								account.setisActivated(true);
								DataStore.writeAccount(account);
								//System.out.println(account);
								MainMenu.show();
								break;
							}
						else
						{
							System.out.println("invalid activation code enter the coide again");
						}
					}
				System.out.println("verification failed");
		}
		MainMenu.show();
	
	}

}