package in.msitprogram.jntu.paypal.accounts;

public class Transaction
{
	String tTime;
	String tDate;
	PPAccount account;
	String narration;
	String reference;
	String status;
	float debit;
	float credit;
	
	public String toString()
	{
		//return the description of the transaction 
		return "account : "+account+"\ntransaction time : "+tTime+"\ntransaction date : "+tDate+"\nnarration : "+narration+"\n reference : "+reference+"\nstatus : "+status+"\ndebit : "+debit+"\ncredit : "+credit;
	}
	
}
