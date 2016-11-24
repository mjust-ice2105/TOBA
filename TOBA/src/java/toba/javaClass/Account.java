package toba.javaClass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

@Entity
public class Account implements Serializable {
    
    
    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AccountId;
    private double balance;
    private String accountType;
    @OneToOne
    private User accountOwner;
    @OneToMany
    private List<Transaction> transactions;
    
    
    // CONSTRUCTORS
    // No Arg Constructor
    public Account() {
        
    }
    
    // Account Object constructor
    public Account(String accountType, double balance, User acctOwner) {
        this.accountType = accountType;
        this.balance = balance;
        this.accountOwner = acctOwner;
    }
    
    
    
    // Getters
    // Setters
    // ToString
    public long getAccountId() {
        return AccountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public void setAccountId(long AccountId) {
        this.AccountId = AccountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountOwner(User accountOwner) {
        this.accountOwner = accountOwner;
    }
    
    // toString method (used for testing, keep just in case)
    @Override
    public String toString() {
        return "Account{" + "AccountId=" + AccountId + ", balance=" + balance + ", accountType=" + accountType + ", accountOwner=" + accountOwner + '}';
    }
    
    
    
    
    
    // Used for mapping Transaction class
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    
    
    
    
    // Methods for Debit and Credit for account transfers
    // Method for adding money to Balance
    public double credit(double amount) {
        
        // Add the amount that is credited to balance. Return balance.
        balance = balance + amount;
        return balance;
    }
    
    // Method for subtracting money from Balance.
    public double debit(double amount) {
        
        balance = balance - amount;
        
        return balance;
    }
    
}
