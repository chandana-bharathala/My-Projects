package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;
import java.util.ArrayList;

public class PPAccount implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Profile profile;
	private String email;
	private String password;
	private float accountBal;
	private boolean isActivated;
	private String activationCode;
	private ArrayList<Transaction> transactions;
	public PPAccount(Profile profile) {
		// TODO Auto-generated constructor stub
		this.profile=profile;
	}

	
	public void activate(String Code) 
	{
		activationCode=Code;
		// TODO Auto-generated method stub	
	}
	
	public String getActivationCode() {
		return activationCode;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setAccountBal(float accountBal) {
		this.accountBal = accountBal;
	}
	
	
	public void setisActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void suspend() 
	{
		System.out.println("your account has been temporarly suspended");
		// TODO Auto-generated method stub
	}
	
	public String toString()
	{
		// implement this function to return a beautiful looking string
		// to display the summary of the account
		return "name :" +profile.getName()+"\naddress : " + profile.getAddress()+"\nphone : " +profile.getPhone()+ "\nemail :" + email + "\naccountBal : " + accountBal + "\nisActivated : "+ isActivated + "\ntransactions : " + transactions;
	}


	public boolean withdraw(float withdrawAmount) {
		this.accountBal=accountBal-withdrawAmount;
		return true;
		
	}


	public boolean addFunds(float creditAmount) 
	{
		this.accountBal=accountBal+creditAmount;
		return true;
	}
	
	public boolean sendMoney(float creditAmount) 
	{
		if(creditAmount<accountBal)
		{
			this.accountBal=accountBal-creditAmount;
			return true;
		}
		else	
		{
		return false;
		}
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}


	public boolean requestMoney(float creditAmount) 
	{

		this.accountBal=accountBal+creditAmount;
		return true;
		
	}
	public float getAccountBal() {
		return accountBal;
	}


	

	
	
}
