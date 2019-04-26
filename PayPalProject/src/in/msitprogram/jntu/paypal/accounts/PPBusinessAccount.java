package in.msitprogram.jntu.paypal.accounts;

import java.util.ArrayList;

public class PPBusinessAccount extends PPAccount {
	
	private ArrayList <PPRestrictedAccount> accountOperators;

	public PPBusinessAccount(Profile profile) {
		super(profile);
		new ArrayList<PPRestrictedAccount>();
	}
	
	public void addAccountOperator(PPRestrictedAccount accountOperator){
		//add account operators after checking if there are duplicates
	}

}
