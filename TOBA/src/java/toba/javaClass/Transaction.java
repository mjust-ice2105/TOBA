package toba.javaClass;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

@Entity
public class Transaction implements Serializable {
    
    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long TransferID;
    private long AccountID;
    private String transType;
    private String acctType;
    private double transAmount;
    
    
    @ManyToOne (cascade=CascadeType.ALL)
    private Account account;
    
    
    
    // CONSTRUCTORS
    // No ARG constructor
    public Transaction() {
        
    }
    
    // Transaction constructor
    public Transaction(long AcctID, String transType, String acctType, double amount) {
        
        this.AccountID = AcctID;
        this.transType = transType;
        this.acctType = acctType;
        this.transAmount = amount;
        
    }
    
    
    
    
    
    // Getters
    // Setters
    // ToString method
    public long getAccountID() {
        return AccountID;
    }
    
    public long getTransferID() {
        return TransferID;
    }
    
    public String getTransType() {
        return transType;
    }

    public String getAcctType() {
        return acctType;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransferID(long TransferID) {
        this.TransferID = TransferID;
    }

    public void setAccountID(long AccountID) {
        this.AccountID = AccountID;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }
    
    @Override
    public String toString() {
        return "Transaction{" + "TransferID=" + TransferID + ", AccountID=" + AccountID + ", transType=" + transType + ", acctType=" + acctType + ", transAmount=" + transAmount + '}';
    }
    
    
    
    
    
    
    // Mapping to Account class (many transactions-->one Account)
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
}
