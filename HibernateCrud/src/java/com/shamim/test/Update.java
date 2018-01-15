package com.shamim.test;

import com.shamim.entity.Employee;
import com.shamim.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class Update {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //-------------Hibernate CRUD------------------
        
        Employee emp = (Employee)session.get(Employee.class, 15);
        emp.setEmpName("Shamim");
        emp.setEmpAddress("Lalmonirhat");
        session.update(emp);       
        
        //---------------------------------------------
        session.getTransaction().commit();
        session.close();
        System.out.println("Success");
    }
}
