import java.util.*;
public class BankAccountMain {
	
	private static boolean isNumeric(String str)
	{
	try
	{
	Double.parseDouble(str);
	return true;
	}
			catch(IllegalArgumentException e)
			{
				return false;
			}
	}
	
	private static boolean isAcct(String str)
	{
	try
	{
	Integer.parseInt(str);
	return true;
	}
			catch(IllegalArgumentException e)
			{
				return false;
			}
	}
	


	public static void main(String[] args) {
		
		//Arraylist and Scanner Declaration
		ArrayList<BankAccount> acct = new ArrayList<BankAccount>();
		Scanner in = new Scanner(System.in);
		
		//Variable Declaration
		final double OVER_DRAFT_FEE = 15;
		final double RATE = 0.0025;
		final double TRANSACTION_FEE = 1.5;
		final double MIN_BAL =  300;
		final double MIN_BAL_FEE = 10;
		final int FREE_TRANSACTION = 10;
		
		//Termination Program Protocol = G
		boolean End = true;
		
		while(End)
		{
		//Initial Start Menu = G
		System.out.println("Would you like to add an account (type add), make a transaction (type transaction), or terminate a program (type terminate)?");
		System.out.println("Answer: ");
		String ans1 = "add";
		String ans2 = "transaction";
		String ans3 = "terminate";
		String answer1 = in.next();
		in.nextLine();
		
		
		//If not valid answer = G
		while(!answer1.equals(ans1) && !answer1.equals(ans2) && !answer1.equals(ans3))
		{
			System.out.println("Not valid, please try again");
			System.out.println("Answer: ");
			answer1 = in.next();
			in.nextLine();
			
		}
		
		//If Answer is to add account = G
		if(answer1.equals(ans1))
		{
			System.out.println("Would you like a Checking Account (type checking), or a Savings Account (type saving)");
			String checking = "checking";
			String saving = "saving";
			System.out.println("Answer: ");
			String answer2 = in.next();
			in.nextLine();
		
			//while neither answer = G
			while(!answer2.equals(checking) && !answer2.equals(saving))
			{
				System.out.println("Not valid, please try again");
				System.out.println("Answer: ");
				answer2 = in.next();
				in.nextLine();
			}
			
			//If Saving = G
			if(answer2.equals(saving))
			{
				System.out.println("What is the name for the Savings account?");
				System.out.print("Answer: ");
				String name1 = in.next();
				in.nextLine();
				
				//Initialize Balance
				System.out.println("Would you like to make an Initial deposit (type yes or no)");
				System.out.print("Answer: ");
				String yes = "yes";
				String no = "no";
				String initializebalance = in.next();
				in.nextLine();
				
				//While neither yes or no = G
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next();
					in.nextLine();
				}
				
				//With Initial Balance = G
				if(initializebalance.equals(yes))
				{
					String deposit;
					double d = 0;
					System.out.println("How much?");
					System.out.print("Amount: ");
					deposit = in.next();
					in.nextLine();
					
					//While not a number = G
					while(!isNumeric(deposit))
					{
						System.out.println("Invalid Response, please try again.");
						System.out.print("Answer: ");
						deposit = in.next();
						in.nextLine();
					}
					
					d = Double.valueOf(deposit).doubleValue();
					
					//Account w/ Balance creation = G
					acct.add(new SavingsAccount(name1, d, RATE, MIN_BAL, MIN_BAL_FEE));
					System.out.println(acct.toString());
				}
				
				//Without Initial Balance = G
				if(initializebalance.equals(no))
				{
					acct.add(new SavingsAccount(name1, RATE, MIN_BAL, MIN_BAL_FEE));
					System.out.println(acct.toString());
				}
			}
			
			//If Checking Account = G
			if(answer2.equals(checking))
			{
				System.out.println("What is the name for the Checking account?");
				System.out.print("Answer: ");
				String name1 = in.next();
				in.nextLine();
				
				//Initialize Balance = G
				System.out.println("Would you like to make an Initial deposit (type yes or no)");
				System.out.print("Answer: ");
				String yes = "yes";
				String no = "no";
				String initializebalance = in.next();
				in.nextLine();
				
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next();
					in.nextLine();
				}
				
				//With Initial Balance = G
				if(initializebalance.equals(yes))
				{
					String deposit;
					double d = 0;
					System.out.println("How much?");
					System.out.print("Amount: ");
					deposit = in.next();
					in.nextLine();
					
					//While not a number = G
				while(!isNumeric(deposit))
				{
					System.out.println("Invalid Response, please try again.");
					System.out.print("Answer: ");
					deposit = in.next();
					in.nextLine();
				}
				
				d = Double.valueOf(deposit).doubleValue();
					
					//Account w/ Balance creation = G
					acct.add(new CheckingAccount(name1, d, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION));
					System.out.println(acct.toString());
				}
				
				//Without Initial Balance = G
				if(initializebalance.equals(no))
				{
					acct.add(new CheckingAccount(name1, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION));
					System.out.println(acct.toString());
				}
			}
		}

		//If transaction method
		if(answer1.equals(ans2))
		{
			System.out.println("Would you like to make a withdraw (withdraw), deposit (deposit), transfer (transfer), or get account numbers (get)");
			System.out.print("Answer: ");
			String transactionType = in.next();
			in.nextLine();
			
			//put error exception = G
			while(!transactionType.equals("withdraw") && !transactionType.equals("deposit") && !transactionType.equals("transfer") && !transactionType.equals("get"))
			{
				System.out.println("Not valid, please try again");
				System.out.println("Answer: ");
				transactionType = in.next();
				in.nextLine();
			}
			
			//switch case methods for declaration = G
			switch(transactionType) {	
			
			case "withdraw" :
			{
				//Finding Account Number 
				System.out.println("Please enter your account number");
				System.out.print("Number: ");
				String acctNum = in.next();
				in.nextLine();
			
				//If account number or not
				while(!isAcct(acctNum) || Integer.parseInt(acctNum) > acct.size() || Integer.parseInt(acctNum) < 0)
				{
			
				}
				
				System.out.println("What is the withdraw amount?");
				System.out.print("Answer: ");
				String amt = in.next();
				in.nextLine();
				
				//Need to add find string mechanic
				while(!isNumeric(amt))
				{
					System.out.println("Invalid Response, please try again.");
					System.out.print("Answer: ");
					amt = in.next();
					in.nextLine();
				}
				
				double amount = Double.valueOf(amt).doubleValue();
				
				//try to execute command
				try
				{
					acct.get(Integer.parseInt(acctNum)).withdraw(amount);
					System.out.println(acct.toString());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Transaction not Authorized");
				}
				break;
			}
			
			case "deposit" :
			{
				//Finding Account Number 
				System.out.println("Please enter your account number");
				System.out.print("Number: ");
				String acctNum = in.next();
				in.nextLine();
			
				//If account number or not
				while(!isAcct(acctNum) || Integer.parseInt(acctNum) > acct.size() || Integer.parseInt(acctNum) < 0)
						{
					
						}
				
				System.out.println("What is the deposit amount?");
				System.out.print("Answer: ");
				String amt = in.next();
				in.nextLine();
				
				// find string mechanic
				while(!isNumeric(amt))
				{
					System.out.println("Invalid Response, please try again.");
					System.out.print("Answer: ");
					amt = in.next();
					in.nextLine();
				}
				
				double amount = Double.valueOf(amt).doubleValue();
				
				//try to execute command
				try
				{
					acct.get(Integer.parseInt(acctNum)).deposit(amount);
					System.out.println(acct.toString());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Transaction not Authorized");
				}
				break;
			}
			
			case "transfer":
			{
				//Finding Account Number 
				System.out.println("Please enter your account number");
				System.out.print("Number: ");
				String acctNum = in.next();
				in.nextLine();
			
				//If account number or not
				while(!isAcct(acctNum) || Integer.parseInt(acctNum) > acct.size() || Integer.parseInt(acctNum) < 0)
			{
					//Special Case = NNNNNNNNNNNNNN
			System.out.println("Invalid Account Number, Try again or get account numbers (get)");
			System.out.print("Answer: ");
			String answer9 = in.next();
			in.nextLine();
			
			switch(answer9) {
				
			case "get":
			{
				System.out.println("What is the account name?");
				String name = in.next();
				in.nextLine();
				int count = 0;
				
				//Finding the accounts = G
			while(count == 0)
			{
				for(BankAccount account : acct)
				{
					if(name.equals(account.getName()))
					{
						if(account instanceof CheckingAccount)
						{
						System.out.println("Checking: " + account.toString());
					    count ++;
						}
						else
						{
							System.out.println("Saving: " + account.toString());
							count ++;
						}
					}
					if(count == 0)
					{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					name = in.next();
					in.nextLine();
					}
				}
			}
			break;
				}
			}
			acctNum = in.next();
				}
				
				//Finding transfer Account Number
				System.out.println("Please enter the bankaccount number that you want to transfer to: ");
				System.out.print("Number: ");
				String transferAcct = in.next();
				in.nextLine();
				
				//If account number or not
				while(!isAcct(transferAcct) || Integer.parseInt(transferAcct) > acct.size() || Integer.parseInt(transferAcct) < 0)
						{
					System.out.println("Invalid Account Number, Try again");
					System.out.print("Number: ");
					transferAcct = in.next();
						}
				
				//determining transfer amount
                System.out.println("What is the transfer amount?");
				
				String amt = in.next();
				in.nextLine();
				
				//if not a number 
				while(!isNumeric(amt))
				{
					System.out.println("Invalid Response, please try again.");
					System.out.print("Answer: ");
					amt = in.next();
					in.nextLine();
				}
				
				double amount = Double.valueOf(amt).doubleValue();
				
				//Execution = G
				try
				{
					acct.get(Integer.parseInt(acctNum)).transfer(acct.get(Integer.parseInt(transferAcct)), amount);
					System.out.println(acct.toString());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Transaction not Authorized");
				}
				break;
			}
			
			case "get":
			{
				//getting the name of account = G
				System.out.println("What is the account name?");
				String name = in.next();
				in.nextLine();
				int count = 0;
				
				//Finding the accounts = G
			while(count == 0)
			{
				for(BankAccount account : acct)
				{
					if(name.equals(account.getName()))
					{
						System.out.println(account.toString());
					count ++;
					}
					if(count == 0)
					{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					name = in.next();
					in.nextLine();
					}
				}
			}
			    break;
			}
			}
		}
		
		if(answer1.equals(ans3))
		{
			System.out.println("System shutting down...");
			End = false;
		}
			
	}

}
}
