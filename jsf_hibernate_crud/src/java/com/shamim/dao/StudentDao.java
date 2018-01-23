package com.shamim.dao;

import com.shamim.pojo.Student;
import com.shamim.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
public class StudentDao {
    
    public List<Student> allStudents(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Student> stlist = session.createCriteria(Student.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        return stlist;
    }
    
    public void add(Student st){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(st);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Student st){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(st);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(Student st){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.delete(st);
        
        session.getTransaction().commit();
        session.close();
    }
}
