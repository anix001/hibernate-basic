package org.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PROJECT STARTED!!" );
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(sessionFactory);

        //creating new student
        Student student = new Student(101, "Anish", "Manpur");
        System.out.println(student);

        Session session = sessionFactory.openSession();

        //begin transaction

        Transaction tx = session.beginTransaction();

        //since save is depricated use persist method
        session.persist(student);

        tx.commit();

        session.close();
    }
}
