package Bank;

import java.util.Calendar;
import java.util.Scanner;

public class Menu {
	// greet customer based on time of day
	public String greet() {
	    Calendar c = Calendar.getInstance();
	    int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

	    if (timeOfDay >= 0 && timeOfDay < 12) {
	        return "Good morning";
	    } else if (timeOfDay >= 12 && timeOfDay < 16) {
	    	return "Good afternoon";
	    } else if (timeOfDay >= 16 && timeOfDay < 21) {
	    	return "Good evening";
	    } else if (timeOfDay >= 21 && timeOfDay < 24) {
	    	return "Good night";
	    } else {
	    	return "Hello";
	    }
	}
	
	public void newSession() {						
		char option = '\0';
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(greet());
		
		// retrieve bank and account based on user input
		System.out.println("Enter your bank : ");
		String bankName = scanner.nextLine();
		
		System.out.println("Enter your account number");
		double number = scanner.nextDouble();
		
		Bank bank = new Bank(bankName);
		BankAccount account = bank.getAccount(number);
		String name = bank.getAccountName(number);		
		
		// greetings
		System.out.println("Welcome back" + name);

		// menu interface
		System.out.println("Chose from following options to\n");
		System.out.println("1: Check your current balance");
		System.out.println("2: Deposit");
		System.out.println("3: Withdraw");
		System.out.println("4: View your last transacion");
		System.out.println("5: Transfer money");
		System.out.println("6: Cancel");
		
		do {
			System.out.println("\nEnter your option : "); 
			option = scanner.next().charAt(0);
			switch(option) {
			case '1':
				System.out.println("\nBalance" + account.getBalance());
				break;
			case '2':
				System.out.println("\nEnter the amount you'd like to deposit");
				double amount = scanner.nextDouble();
				account.deposit(amount);
				break;
			case '3':
				System.out.println("\nEnter the amount you'd like to withdraw");
				amount = scanner.nextDouble();
				account.withdraw(amount);
				break;
			case '4':
				System.out.println("\n");
				account.getPreviousTransaction();
				break;
			case '5':
				System.out.println("\nEnter the amount you'd like to transfer : ");
				amount = scanner.nextDouble();
				System.out.println("\nEnter the account number you'd like to transfer money to : ");
				double destinationAccountNumber = scanner.nextDouble();
				// retrieve destination account based on account number user input
				BankAccount destinationAccount = bank.getAccount(destinationAccountNumber);
				account.transfer(destinationAccount, amount);
				break;
			case '6':
				System.out.println("-----------------------------------------------------------");
				break;
			default:
				System.out.println("\nInvalid option. Please enter a correct option.");
			}
		} while(option != '6'); {
			System.out.println("Thank you for using our services. Have a great day !");
		}
		
		scanner.close();
		
	}
}
