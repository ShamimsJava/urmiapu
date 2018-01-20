package dao;

import entity.Category;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Shamim
 */
public class AddDao {
    public boolean addCategory(Category cat){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(cat);
            
            session.getTransaction().commit();
            session.close();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
