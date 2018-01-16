package com.shamim.entity;

import com.shamim.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Shamim
 */
@ManagedBean
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void save(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        User user = new User(username, password);
        session.save(user);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public String validate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from User where username=:username and password=:password");
        query.setString("username", username);
        query.setString("password", password);
        List list = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        if(list.size()>0){
            return "welcome";
        }else{
            return "error";
        }
    }
}
