/**
 * 
 */
package in.msitprogram.jntu.paypal.console;

import java.util.Scanner;

import in.msitprogram.jntu.paypal.persistance.DataStore;

/**
 * @author pg
 *
 */
public class MainMenu {
	
	public static void show() throws Exception{
		//show the welcome message with the main menu options
		//take the menu option as input from the console
		//take email address as input from the console
		//based on the given menu option instantiate the respective screens
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome to paypal transactions");
		System.out.println("1. logn in\n"+ "2.create an account");
		n=sc.nextInt();
		switch(n)
		{
		case 1: System.out.println("enter email address");
				String email1=sc.next(); 
				System.out.println("enter the password");
				String password1 = sc.next();
				PPAccountScreen ppa= new PPAccountScreen(email1, password1);
				ppa.show();
				break;
		
		case 2: System.out.println("enter email address");
				String email=sc.next();
				System.out.println("enter the password" );
				String password=sc.next();
				PPNewAccountScreen ppn=new PPNewAccountScreen(email, password);
				ppn.show();
				break;
		}
	}

}
