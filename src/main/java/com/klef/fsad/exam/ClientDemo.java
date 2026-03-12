package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

Session session = HibernateUtil.getSessionFactory().openSession();

Transaction tx = session.beginTransaction();

Course c = new Course();

System.out.println("Enter Course Name:");
c.setName(sc.nextLine());

System.out.println("Enter Description:");
c.setDescription(sc.nextLine());

c.setDate(new Date());

System.out.println("Enter Status:");
c.setStatus(sc.nextLine());

session.save(c);

tx.commit();

System.out.println("Course Inserted Successfully");

System.out.println("Enter ID to View:");

int id = sc.nextInt();

Course course = session.get(Course.class,id);

if(course!=null)
{
System.out.println("ID:"+course.getId());
System.out.println("Name:"+course.getName());
System.out.println("Description:"+course.getDescription());
System.out.println("Date:"+course.getDate());
System.out.println("Status:"+course.getStatus());
}
else
{
System.out.println("Course Not Found");
}

session.close();

}
}