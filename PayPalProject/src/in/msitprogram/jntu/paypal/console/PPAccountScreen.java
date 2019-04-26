package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;

public class PPAccountScreen {
	PPAccount account;
	Scanner scan;
	
	public PPAccountScreen(String email, String password) throws Exception, IOException {
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email, password);
	}

	public void show() throws Exception {
		//check if account is active
		//if active
		// print the account summary
		// print menu and accept menu options
		// for all the paypal account operations
		if(account!=null)
		{
			if(account.isActivated())
			{
				System.out.println("account summary");
				System.out.println("--------------------------");
				System.out.println(account);
				System.out.println("--------------------------");
				System.out.println("selsect the type of transactions");
				System.out.println("1. withdraw\n"+"2. requestmoney\n"+"3.send money\n"+"4. add funds\n"+"5. main menu");
				System.out.println("--------------------------");
				int n=scan.nextInt();
				switch(n)
				{
				case 1:withdrawFunds();
						break;
				case 2:requestMoney();
						break;
				case 3:sendMoney();
						break;
				case 4:addFunds();
						break;
				case 5:MainMenu.show();
						break;
				}
			}
			else
			{
				MainMenu.show();
			}
		}	
		else
		{
			System.out.println("Acount Does not Exist. Please create new Account");
			MainMenu.show();
		}
}

	private void withdrawFunds() throws Exception {
		// implement the withdraw funds user interface here
		
		//use the account object as needed for withdraw funds
		System.out.println("enter the ammount you want to withdraw");
		float withdrawAmount=scan.nextFloat();
		if(withdrawAmount<account.getAccountBal())
		{
			//account.withdraw(withdrawAmount);
			System.out.println("withdraw transaction staus : "+account.withdraw(withdrawAmount));
			System.out.println("your avaliable account balance ---- "+account.getAccountBal());
			DataStore.writeAccount(account);
			show();
		}
		else
		{
			System.out.println("withdraw transaction failed");
			System.out.println("entered ammount is more than the avaliable balance");
			System.out.println("your avaliable account balance ---- "+account.getAccountBal());
			show();
		}
		
	}

	private void requestMoney() {
		// 	implement the request money user interface here
		
		//use the account object as needed for request money funds
	}

	private void sendMoney() {
		// implement the send moeny user interface here
		
		//use the account object as needed for send money funds
	
	}

	private void addFunds() throws Exception {
		// implement the add funds user interface here
		
		//use the account object as needed for add funds	
		System.out.println("enter the ammount you want to add");
		float creditAmount=scan.nextFloat();
		//account.withdraw(creditAmount);
		System.out.println("credit Amount transaction staus : "+account.addFunds(creditAmount));
		System.out.println("your avaliable account balance ---- "+account.getAccountBal());
		DataStore.writeAccount(account);
		show();
	}

}