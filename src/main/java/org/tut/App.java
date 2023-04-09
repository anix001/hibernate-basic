package org.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "PROJECT STARTED!!" );
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(sessionFactory);

        //creating new student
        Student student = new Student(101, "Anish", "Manpur");
        Certificate student1Certi = new Certificate("Java", "3 months");
        student.setCerti(student1Certi);
        System.out.println(student);

        Student student2 = new Student(102, "Panchu", "Bhasi");
        Certificate student2Certi = new Certificate("Arts", "2 months");
        student2.setCerti(student2Certi);

        //creating Object of address
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("Manpur");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.12);

        //reading image
//        FileInputStream fileInputStream = new FileInputStream("");
//        byte[] data = new byte[fileInputStream.available()];
//        fileInputStream.read(data);
//        address.setImage(data);

        Session session = sessionFactory.openSession();

        //begin transaction

        Transaction tx = session.beginTransaction();

        //since save is depricated use persist method
        session.persist(student);
        session.persist(student2);
        session.persist(address);

        tx.commit();

        //get method
//        Student findStudent  = (Student) session.load(Student.class, 101);
//        System.out.println("Student details:"+" " + findStudent);

        //load method
//        Address findStudentAddress = (Address) session.get(Address.class, 1);
//        System.out.println("findaddress"  + findStudentAddress);

        session.close();
        System.out.println("Done ....");
    }
}
