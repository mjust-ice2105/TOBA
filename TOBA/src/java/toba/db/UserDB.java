package toba.db;

import toba.util.DBUtil;
import toba.javaClass.User;
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

public class UserDB {
    
    
    // Method for Inserting User Object to database. DB = TOBA; Table = USER
    public static void insert(User user) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            em.persist(user);
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
    public static void update(User user) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        }
        catch (Exception e) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    
    
    
    //
    public static void delete(User user) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        }
        catch (Exception e) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    //
    public static User selectUser(String userName) {
        
        // Select statement to get User Object data from USER Table in DB = TOBA
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT u FROM User u " +
                "WHERE u.userName = :username";
        
        TypedQuery<User> q = em.createQuery(query, User.class);
        q.setParameter("username", userName);
        
        try {
            User userInfo = q.getSingleResult();
            return userInfo;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
        
    }
    
    
    
    
}
