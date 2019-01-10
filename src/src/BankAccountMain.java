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
		System.out.println("Would you like to add an account (type add), make a transaction (type transaction), or terminate the program (type terminate)?");
		System.out.println("Answer: ");
		String ans1 = "add";
		String ans2 = "transaction";
		String ans3 = "terminate";
		String answer1 = in.next().toLowerCase();
		in.nextLine();
		
		
		//If not valid answer = G
		while(!answer1.equals(ans1) && !answer1.equals(ans2) && !answer1.equals(ans3))
		{
			System.out.println("Not valid, please try again");
			System.out.println("Answer: ");
			answer1 = in.next().toLowerCase();
			in.nextLine();
			
		}
		
		//If Answer is to add account = G
		if(answer1.equals(ans1))
		{
			System.out.println("Would you like a Checking Account (type checking), or a Savings Account (type saving)");
			String checking = "checking";
			String saving = "saving";
			System.out.println("Answer: ");
			String answer2 = in.next().toLowerCase();
			in.nextLine();
		
			//while neither answer = G
			while(!answer2.equals(checking) && !answer2.equals(saving))
			{
				System.out.println("Not valid, please try again");
				System.out.println("Answer: ");
				answer2 = in.next().toLowerCase();
				in.nextLine();
			}
			
			//If Saving = G
			if(answer2.equals(saving))
			{
				System.out.println("What is the name for the account?");
				System.out.print("Answer: ");
				String name1 = in.next().toLowerCase();
				in.nextLine();
				
				//Initialize Balance
				System.out.println("Would you like to make an Initial deposit (type yes or no)");
				System.out.print("Answer: ");
				String yes = "yes";
				String no = "no";
				String initializebalance = in.next().toLowerCase();
				in.nextLine();
				
				//While neither yes or no = G
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next().toLowerCase();
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
					SavingsAccount acc = new SavingsAccount(name1, d, RATE, MIN_BAL, MIN_BAL_FEE);
					acct.add(acc);
					System.out.println(acc.toString());
				}
				
				//Without Initial Balance = G
				if(initializebalance.equals(no))
				{
					SavingsAccount acc = new SavingsAccount(name1, RATE, MIN_BAL, MIN_BAL_FEE);
					acct.add(acc);
					System.out.println(acc.toString());
				}
			}
			
			//If Checking Account = G
			if(answer2.equals(checking))
			{
				System.out.println("What is the name for the Checking account?");
				System.out.print("Answer: ");
				String name1 = in.next().toLowerCase();
				in.nextLine();
				
				//Initialize Balance = G
				System.out.println("Would you like to make an Initial deposit (type yes or no)");
				System.out.print("Answer: ");
				String yes = "yes";
				String no = "no";
				String initializebalance = in.next().toLowerCase();
				in.nextLine();
				
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next().toLowerCase();
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
				CheckingAccount acc = new CheckingAccount(name1, d, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
					acct.add(acc);
					System.out.println(acc.toString());
				}
				
				//Without Initial Balance = G
				if(initializebalance.equals(no))
				{
					CheckingAccount acc = new CheckingAccount(name1, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
					acct.add(acc);
					System.out.println(acc.toString());
				}
			}
		}

		//If transaction method
		if(answer1.equals(ans2))
		{
			//Finding Account Number 
			System.out.println("Please enter your account number");
			System.out.print("Number: ");
			String acctNum = in.next();
			in.nextLine();
			
			//If account number or not
			while(!isAcct(acctNum) || Integer.parseInt(acctNum) > acct.size() - 1 || Integer.parseInt(acctNum) < 0)
			{
				//Special Case = NNNNNNNNNNNNNN
				System.out.println("Invalid Account Number, Try again (try) or get account numbers (get)");
				System.out.print("Answer: ");
				String ans13 = "get";
				String ans14 = "try";
				String answer9 = in.next().toLowerCase();
				in.nextLine();
				int Number;
				
				if(!answer9.equals(ans13) && !answer9.equals(ans14)) {
					
					System.out.println("Invalid, try again");
					System.out.print("Answer: ");
					answer9 = in.next().toLowerCase();
				}
				
				if(answer9.equals(ans13)) {
					
					System.out.println("What is the account name?");
					String name = in.next().toLowerCase();
					in.nextLine();
					
						//Finding the accounts = G
						for(BankAccount account : acct)
						{
							if(name.equals(account.getName()))
							{
								if(account instanceof CheckingAccount)
								{
								System.out.println("Checking: " + account.toString());
							   Number = account.getAcctNum();
							  acctNum = Integer.toString(Number);
								}
								else
								{
									System.out.println("Saving: " + account.toString());
									 Number = account.getAcctNum();
									  acctNum = Integer.toString(Number);
								}
							}
						}
						if (acct.size() >= 0)
						{
						System.out.println("The last account in the list is where the transaction will occur in");
						}
						
						if(acct.size() == 0)
						{
							System.out.println("No Accounts Detected");	
						}
				
						break;
}
				else if(answer9.equals(ans14))
				{
					System.out.println("Account Number: ");
					acctNum = in.next();
				}
			}
			
			String transactionType;
		
			System.out.println("Would you like to make a withdraw (withdraw), deposit (deposit), transfer (transfer), get account numbers (get), or return to main menu (return)");
			System.out.print("Answer: ");
		    transactionType = in.next().toLowerCase();
			in.nextLine();
			
			
			//put error exception = G
			while(!transactionType.equals("withdraw") && !transactionType.equals("deposit") && !transactionType.equals("transfer") && !transactionType.equals("get") && !transactionType.equals("return"))
			{
				System.out.println("Not valid, please try again");
				System.out.println("Answer: ");
				transactionType = in.next().toLowerCase();
				in.nextLine();
			}
			
			if(acct.size() == 0)
			{
				 transactionType = "return";
				 System.out.println("Error no accounts found");
			}
			
			//switch case methods for declaration = G
			switch(transactionType) {	
			
			case "withdraw" :
			{
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
				
				//Finding transfer Account Number
				System.out.println("Please enter the bankaccount number that you want to transfer to: ");
				System.out.print("Number: ");
				String transferAcct = in.next();
				in.nextLine();
				
				//If account number or not
				while(!isAcct(transferAcct) || Integer.parseInt(transferAcct) > acct.size() - 1 || Integer.parseInt(transferAcct) < 0 || Integer.parseInt(transferAcct) == Integer.parseInt(acctNum))
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
				String name = in.next().toLowerCase();
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
			case "return":
			{
				System.out.println("Returning...");
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