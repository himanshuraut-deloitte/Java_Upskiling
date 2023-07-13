package Mini_Assignment1;

import org.apache.log4j.Logger;

class Account {
    static Logger logger = Logger.getLogger(Account.class);
    protected double balance;

    /**
     * Creates an Account object with the specified initial balance.
     * @param balance The initial balance of the account.
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * Gets the current balance of the account.
     * @return The current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Calculates the interest amount for the account.
     * This method is not implemented in the base class and serves as a placeholder for specific interest calculation in derived classes.
     * Override this method in the derived classes to provide the interest calculation formula.
     */
    public void calculateInterest() {
        double interestRate = 0.02;
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Interest calculation in Account: " + interest);
    }
}

class SavingsAccount extends Account {

    /**
     * Creates a SavingsAccount object with the specified initial balance and interest rate.
     * @param balance  The initial balance of the account.
     */
    public SavingsAccount(double balance) {
        super(balance);
    }

    /**
     * Calculates the interest amount for the savings account based on the specified interest rate.
     * Updates the balance by adding the interest amount.
     */
    @Override
    public void calculateInterest() {
        double interestRate = 0.05;
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Interest calculation in SavingsAccount: " + interest);
    }
}

class CheckingAccount extends Account {

    /**
     * Creates a CheckingAccount object with the specified initial balance and interest rate.
     * @param balance The initial balance of the account.
     */
    public CheckingAccount(double balance) {
        super(balance);
    }

    /**
     * Calculates the interest for the checking account based on the specified interest rate.
     * No interest is calculated for check account.
     */
    @Override
    public void calculateInterest() {
        double interestRate = 0.08;
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Interest calculation in CheckingAccount: " + interest);
    }
}

public class AccountManagement {
    static Logger logger = Logger.getLogger(AccountManagement.class);

    public static void main(String[] args) {
        Account account = new Account(10000);
        account.calculateInterest();
        logger.info("Account Balance: " + account.getBalance());

        Account savingsAccount = new SavingsAccount(5000);
        savingsAccount.calculateInterest();
        logger.info("Savings Account Balance: " + savingsAccount.getBalance());

        Account checkingAccount = new CheckingAccount(3000);
        checkingAccount.calculateInterest();
        logger.info("Checking Account Balance: " + checkingAccount.getBalance());
    }
}
