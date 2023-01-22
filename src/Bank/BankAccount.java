package Bank;

public class BankAccount {
    private double accountNumber;
    private double balance;
    private String accountHolder;
    private double previousTransaction;

    public BankAccount(double accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        balance += amount;
        previousTransaction = amount;
    }

    public boolean withdraw(double amount) {
        if(balance >= 0) {
            balance -= amount;
			previousTransaction = -amount;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if(withdraw(amount)) {
            destinationAccount.deposit(amount);
            previousTransaction = -amount;
            return true;
        }
        return false;
    }
    
    public void getPreviousTransaction() {
    	if (previousTransaction > 0) {
    		System.out.println("Desposited : " + previousTransaction);
    	}
    	
    	else if (previousTransaction < 0){
    		System.out.println("Withdrew : " + previousTransaction);
    	}
    	
    	else {
    		System.out.println("No transaction occured");
    	}
    }
    
}
