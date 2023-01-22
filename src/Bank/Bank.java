package Bank;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<BankAccount> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(double accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    
    public String getAccountName(double accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account.getAccountHolder();
            }
        }
        return null;
    }

    public boolean removeAccount(double accountNumber) {
        BankAccount accountToRemove = getAccount(accountNumber);
        if (accountToRemove != null) {
            return accounts.remove(accountToRemove);
        }
        return false;
    }
    
    // add interest and loaning feature
}
