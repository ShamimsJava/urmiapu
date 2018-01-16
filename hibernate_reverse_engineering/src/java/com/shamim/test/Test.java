package com.shamim.test;

import com.shamim.entity.User;
import com.shamim.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        User user = (User)session.get(User.class, 4);
        System.out.println(user.getUsername());
        
        session.getTransaction().commit();
        session.close();
        System.out.println("Success");
    }
}
