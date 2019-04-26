package in.msitprogram.jntu.paypal.accounts;

public class PPRestrictedAccount extends PPAccount {
	private String parentEmail;
	private float withdrawLimit;
	public void setparentEmail(String parentEmail) {
		this.parentEmail=parentEmail;
	}
	public void setwithdrawLimit(float withdrawLimit) {
		this.withdrawLimit=withdrawLimit;
	}
	public String getparentEmail() {
		return parentEmail;
	}
	public float getwithdrawLimit() {
		return withdrawLimit;
	}

	public PPRestrictedAccount(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

}
