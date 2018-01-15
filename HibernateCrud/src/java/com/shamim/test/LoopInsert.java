package com.shamim.test;

import com.shamim.entity.Employee;
import com.shamim.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class LoopInsert {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //-------------Hibernate CRUD------------------
        
        for (int i = 0; i < 50; i++) {
            Employee emp = new Employee("EmpName "+i, "EmpAddress "+i);
            session.save(emp);
        }
        
        //---------------------------------------------
        session.getTransaction().commit();
        session.close();
        System.out.println("Success");
    }
}
