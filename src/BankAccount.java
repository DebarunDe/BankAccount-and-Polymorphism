
public abstract class BankAccount {
	
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	
	public BankAccount(String n) {
		
	    name = n;
		acctNum = nextAccNum + 1;
		balance = 0;
	}

	public BankAccount(String n, double b) {
		
		name = n;
		acctNum = nextAccNum + 1;
		this.balance = b;
	}
	
	public void deposit(double amt) {
		
		balance += amt;
	}
	
	public void withdraw(double amt) {
		
		balance -= amt;
	}
	
	public String getName() {
		
		return name;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
	public void transfer(BankAccount other, double amt) {
		
		balance -= amt;
		other.balance += amt;
		
	}
	
	public String toString() {
		
		return acctNum + " " + name + " " + "$" + balance;
		
	}
}
