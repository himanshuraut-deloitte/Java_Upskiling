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
     * Calculates the interest for the account.
     * This method is not implemented in the base class and serves as a placeholder for specific interest calculation in derived classes.
     * Override this method in the derived classes to provide the interest calculation formula.
     */
    public void calculateInterest() {
        logger.info("No interest calculated for the base Account.");
    }

    /**
     * Gets the current balance of the account.
     * @return The current balance of the account.
     */
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    /**
     * Creates a SavingsAccount object with the specified initial balance and interest rate.
     * @param balance      The initial balance of the account.
     * @param interestRate The interest rate for calculating interest.
     */
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Calculates the interest for the savings account based on the specified interest rate.
     * Updates the balance by adding the interest amount.
     */
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Interest calculated for SavingsAccount: " + interest);
    }
}

class CheckingAccount extends Account {
    private double interestRate;

    /**
     * Creates a CheckingAccount object with the specified initial balance and interest rate.
     * @param balance      The initial balance of the account.
     * @param interestRate The interest rate for calculating interest.
     */
    public CheckingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Calculates the interest for the checking account based on the specified interest rate.
     * Updates the balance by adding the interest amount.
     */
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        logger.info("Interest calculated for CheckingAccount: " + interest);
    }
}

public class AccountManagement {
    static Logger logger = Logger.getLogger(AccountManagement.class);

    public static void main(String[] args) {
        Account account1 = new SavingsAccount(5000, 0.05);
        Account account2 = new CheckingAccount(3000, 0.03);

        account1.calculateInterest();
        account2.calculateInterest();

        logger.info("Updated balance for account1: " + account1.getBalance());
        logger.info("Updated balance for account2: " + account2.getBalance());
    }
}
