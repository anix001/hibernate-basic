package org.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = factory.openSession();

        Query query = s.createQuery("from Student ", Student.class);

        //implementing pagination using Hibernate

        query.setFirstResult(0);
        query.setMaxResults(5);

        List<Student> studentList = query.list();

        for (Student student:studentList){
            System.out.println(student.getId() + " : " + student.getName() + " : "+ student.getCity());
        }

        s.close();
        factory.close();
    }
}
