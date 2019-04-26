package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPBusinessAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

public class PPNewAccountScreen implements Serializable {
	Profile profile;
	PPAccount account;
	String email;
	String password;
	Scanner scan;
	
	public PPNewAccountScreen(String email, String password) {
		//profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
		this.password=password;
	}

	public void show() throws Exception {
		//check if the account with the given email address exists 
		//if not create the user profile
		//show the account types
		//based on the given account type selected create the account object
		if(DataStore.lookupAccount(email, password)!= null)
		{
			System.out.println("you alredy have an account login with yor account");
			MainMenu.show();
		}
		else
		{
		int n;
		createProfile();
		System.out.println("select the type of account you wanted to create");
		System.out.println("1. personal account\n"+"2. student account\n"+ "3.business account");
		n=scan.nextInt();
		switch(n)
		{
			case 1: createPersonalAccount();
					break;
			case 2: createStudentAccount();
					break;
			case 3: createBusinessAccount();
					break;
		}
		}
	}
	private Profile createProfile() {
		// use this for creating the profile
		profile=new Profile();
		String name;
		String address;
		String phone;
		System.out.println("enter  full name");
		name=scan.next();
		profile.setName(name);
		System.out.println("enter your address");
		address=scan.next();
		profile.setAddress(address);
		System.out.println("enter your phone number");
		phone=scan.next();
		profile.setPhone(phone);
		return profile;
	}

	private void createBusinessAccount() throws IOException {
		//use this for creating the business account
	}

	private void createStudentAccount() throws IOException {
		//use this for creating the student account 
	}

	/*
	 * this method create the personal account, saves it to the file system
	 * and redirects the users to the next screen
	 */
	private void createPersonalAccount() throws Exception {
		//use this for creating the personal account
		account=new PPAccount(profile);
		System.out.println("enter the balance");
		float balance = scan.nextFloat();
		account.setAccountBal(balance);
		account.setEmail(email);
		account.setPassword(password);
		DataStore.writeAccount(account);
		completeAccountCreation();
	}
	
	private void completeAccountCreation() throws Exception{
		//generate activation code and set it to account
		
		//send activation code to the phone
		
		//ask & redirect the user to the activation screen or the main menu
		int n;
		String str=PPToolkit.generateActivationCode();
		account.activate(str);
		System.out.println("1.activate your account\n"+"2. main menu");
		n=scan.nextInt();
		switch(n)
		{
		case 1: PPAccountActivationScreen.show();
				break;
		case 2: MainMenu.show();
				break;
		}	
	}

}
