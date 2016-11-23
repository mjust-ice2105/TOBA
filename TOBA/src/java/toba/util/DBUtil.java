package toba.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

public class DBUtil {
    
    //
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("TOBAPU");
    
    //
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
    
}
