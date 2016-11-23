package toba.db;

import toba.util.DBUtil;
import toba.javaClass.Transaction;
import toba.javaClass.Account;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

public class AccountDB {
    
    
    // Method for Inserting Account Object to database. DB = TOBA; Table = USER
    public static void insert(Account acctInfo) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            
            em.persist(acctInfo);
            trans.commit();
        }
        catch (Exception e) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    
    // Method for updating User Object to database. DB = TOBA; Table = USER
    public static void update(Account acctInfo) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(acctInfo);
            trans.commit();
        }
        catch (Exception e) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    
    
    // Select statement to get SAVINGS account info
    public static Account selectSavAccount(long UserID) {
        
        // Select Statement to get Account data from DB = TOBA
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT a FROM Account a " +
                "WHERE a.accountOwner.userId = :userID and a.accountType = 'Savings'";
        
        TypedQuery<Account> q = em.createQuery(query, Account.class);
        q.setParameter("userID", UserID);
        
        try {
            Account savInfo = q.getSingleResult();
            return savInfo;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
        
    }
    
    // Select statement to get CHECKING account info
    public static Account selectChkAccount(long UserID) {
        
        // Select Statement to get Account data from DB = TOBA
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT a FROM Account a " +
                "WHERE a.accountOwner.userId = :userID and a.accountType = 'Checking'";
        
        TypedQuery<Account> q = em.createQuery(query, Account.class);
        q.setParameter("userID", UserID);
        
        try {
            Account savInfo = q.getSingleResult();
            return savInfo;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
        
    }
    
    
    
    // Select statemnet to get SAVINGS account transaction data
    public static List<Transaction> selectSavingAccountTransactions(long AccountID) {
        
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT t FROM Transaction t " +
                "WHERE t.AccountID = :accountId and t.acctType = 'Savings'";
        
        TypedQuery<Transaction> q = em.createQuery(query, Transaction.class);
        q.setParameter("accountId", AccountID);
        
        List<Transaction> Transactions;
        
        try {
            Transactions = q.getResultList();
            
        }
        finally {
            em.close();
        }
        
        return Transactions;
        
    }
    
    // select statement to get CHECKING account transaction data
    public static List<Transaction> selectCheckingAccountTransactions(long AccountID) {
        
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT t FROM Transaction t " +
                "WHERE t.AccountID = :accountId and t.acctType = 'Checking'";
        
        TypedQuery<Transaction> q = em.createQuery(query, Transaction.class);
        q.setParameter("accountId", AccountID);
        
        List<Transaction> Transactions;
        
        try {
            Transactions = q.getResultList();
            
        }
        finally {
            em.close();
        }
        
        return Transactions;
        
    }
    
}
