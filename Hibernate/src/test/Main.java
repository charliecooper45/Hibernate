package test;

import hibernate.classes.Student;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        session.beginTransaction();
//        Student student = new Student();
//
//        student.setStudentName("JavaFun");
//        student.setStudentAge("19");
//
//        session.save(student);
//        session.getTransaction().commit();
//        System.out.println("Great! Student was saved");
        
        Query namedQuery = session.getNamedQuery(Student.QUERY_BY_STUDENT_ID);
        namedQuery.setInteger("studentId", 1);
        Student uniqueResult = (Student) namedQuery.uniqueResult();
        System.out.println(uniqueResult);
	}
}
