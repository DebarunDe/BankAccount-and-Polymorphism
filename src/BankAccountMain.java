import java.util.*;
public class BankAccountMain {

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
		
		//Initial Start Menu
		System.out.println("Would you like to add an account (type add), make a transaction (type make transaction), or terminate a program (type terminate program)?");
		System.out.println("Answer: ");
		String ans1 = "add";
		String ans2 = "make transaction";
		String ans3 = "terminate program";
		String answer1 = in.next();
		in.nextLine();
		
		//If not valid answer
		while(!answer1.equals(ans1) && !answer1.equals(ans2) && !answer1.equals(ans3))
		{
			System.out.println("Not valid, please try again");
			System.out.println("Answer: ");
			answer1 = in.next();
			in.nextLine();
		}
		
		//If Answer is to add account
		if(answer1.equals(ans1))
		{
			System.out.println("Would you like a Checking Account (type checking), or a Savings Account (type saving)");
			String checking = "checking";
			String saving = "saving";
			System.out.println("Answer: ");
			String answer2 = in.next();
			in.nextLine();
			
			while(!answer2.equals(checking) && !answer2.equals(saving))
			{
				System.out.println("Not valid, please try again");
				System.out.println("Answer: ");
				answer2 = in.next();
				in.nextLine();
			}
			
			//If Saving
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
				
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next();
					in.nextLine();
				}
				
				//With Initial Balance 
				if(initializebalance.equals(yes))
				{
					System.out.println("How much?");
					System.out.print("Amount: ");
					double deposit = in.nextDouble();
					in.nextLine();
					
					//Account w/ Balance creation
					acct.add(new SavingsAccount(name1, deposit, RATE, MIN_BAL, MIN_BAL_FEE));
					System.out.println(acct.toString());
				}
				
				//Without Initial Balance
				if(initializebalance.equals(no))
				{
					acct.add(new SavingsAccount(name1, RATE, MIN_BAL, MIN_BAL_FEE));
					System.out.println(acct.toString());
				}
			}
			
			//If Checking Account
			if(answer2.equals(checking))
			{
				System.out.println("What is the name for the Checking account?");
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
				
				while(!initializebalance.equals(yes) && !initializebalance.equals(no))
				{
					System.out.println("Not valid, please try again");
					System.out.println("Answer: ");
					initializebalance = in.next();
					in.nextLine();
				}
				
				//With Initial Balance 
				if(initializebalance.equals(yes))
				{
					System.out.println("How much?");
					System.out.print("Amount: ");
					boolean dean = true;
					double deposit=0;
					
					//While not a number
				while(dean)	{
					try{
						deposit = in.nextDouble();
						in.nextLine();
						
						dean = false;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Not valid, please enter a number");
						System.out.println("Answer: ");
					}
				}
					in.nextLine();
					
					//Account w/ Balance creation
					acct.add(new CheckingAccount(name1, deposit, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION));
					System.out.println(acct.toString());
				}
				
				//Without Initial Balance
				if(initializebalance.equals(no))
				{
					acct.add(new CheckingAccount(name1, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION));
					System.out.println(acct.toString());
				}
			}
		}
	}

}
