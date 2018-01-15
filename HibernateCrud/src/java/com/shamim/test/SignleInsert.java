package com.shamim.test;

import com.shamim.entity.Employee;
import com.shamim.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class SignleInsert {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //-------------Hibernate CRUD------------------
        
        Employee emp1 = new Employee("Amjad", "Noakhali");
        
        Employee emp2 = new Employee();
        emp2.setEmpName("Manju");
        emp2.setEmpAddress("Dhaka");
        
        session.save(emp1);
        session.persist(emp2);
        
        //---------------------------------------------
        session.getTransaction().commit();
        session.close();
        System.out.println("Success");
    }
}
