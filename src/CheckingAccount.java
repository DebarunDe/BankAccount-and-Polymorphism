
public class CheckingAccount extends BankAccount{

	private  final double OVER_DRAFT_FEE;
	private  final double TRANSACTION_FEE;
	private  final double FREE_TRANS;
	
	private int numTransactions = 0;
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans) {
		
		super(n,b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	public CheckingAccount(String n, double odf, double tf, int freeTrans) {
		
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		
	}
	
	public void overrideDeposit(double amt) {
		
		if(amt <= 0)
		{
			throw new IllegalArgumentException("Error");
		}
		
		numTransactions ++;
		amt = amt - TRANSACTION_FEE;
		super.deposit(amt);
		
	}
	
public void overrideWithdraw(double amt) {
		
		if(getBalance() <= 0)
		{
			throw new IllegalArgumentException("Error");
		}
		
		numTransactions ++;
		
		if(getBalance() - amt < 0)
		{
			super.withdraw(amt + OVER_DRAFT_FEE);
		}
		else {
			super.withdraw(amt);
		}
}


	
	
}
