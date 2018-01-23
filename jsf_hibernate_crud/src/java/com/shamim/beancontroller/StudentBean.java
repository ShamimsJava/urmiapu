package com.shamim.beancontroller;

import com.shamim.dao.StudentDao;
import com.shamim.pojo.Student;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Shamim
 */
@ManagedBean
@ViewScoped
public class StudentBean {
    Student student = new Student();
    StudentDao studentdao = new StudentDao();
    private String username;
    private String password;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentDao getStudentdao() {
        return studentdao;
    }

    public void setStudentdao(StudentDao studentdao) {
        this.studentdao = studentdao;
    }
    
    public List<Student> displayall(){
        List<Student> stlist = studentdao.allStudents();
        return stlist;
    }
    
    public String addUser(){
        studentdao.add(student);
        return "display.xhtml?faces-redirect=true";
    }
    
    public String updateUser(Student std){
        studentdao.update(std);
        return "display.xhtml?faces-redirect=true";
    }
    
    public String deleteUser(Student std){
        studentdao.delete(std);
        return "display.xhtml?faces-redirect=true";
    }
    
    public void changeStudent(Student student){
        this.student = student;
    }
    
    public String validate(){
        if(username.equals("urmi") && password.equals("123")){
            return "display";
        }else{
            return "error";
        }
    }
}
