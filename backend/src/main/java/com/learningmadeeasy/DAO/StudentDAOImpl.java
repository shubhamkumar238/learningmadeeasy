package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAOInterface {
	
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Student theStudent) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		currentSession.saveOrUpdate(theStudent);
		
	}

	@Override
	public int saveStudent(Map<String, ?> theStudent) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Student newStudent = new Student();
		
		Query query = entityManager.createQuery("from Course where courseId=:courseId");
		query.setParameter("courseId",(Integer) theStudent.get("courseId"));
		
		Course theCourse = (Course) query.getSingleResult();
		
		newStudent.setStudentId((Integer) theStudent.get("studentId"));
		newStudent.setName((String) theStudent.get("studentName"));
		newStudent.setEmail((String) theStudent.get("email"));
		newStudent.addCourse(theCourse);
		
		currentSession.save(newStudent);
		System.out.println(newStudent);
		
		return newStudent.getStudentId();
	}

	@Override
	public void savecourseforstudent(int studentId, int courseId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = entityManager.createQuery("from Course where courseId=:courseId");
		query.setParameter("courseId",courseId);
		
		Course theCourse = (Course) query.getSingleResult();
		
		Query query2 = entityManager.createQuery("from Student where studentId=:studentId");
		query2.setParameter("studentId",studentId);
		
		
		Student theStudent = (Student) query2.getSingleResult();
		
		System.out.println(theStudent);
		
		System.out.println(theCourse);
		
		//Student theStudent = currentSession.get(Student.class, studentId);
		
		//Course theCourse = currentSession.get(Course.class, courseId);

		
		theStudent.addCourse(theCourse);
		
		System.out.println(theStudent.getCourses());
		
		//theCourse.addStudent(theStudent);
		
		currentSession.save(theStudent);
		
		
	}

	@Override
	public List<Course> getAllCourses(int studentId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = entityManager.createQuery("from Student where studentId=:studentId");
		query.setParameter("studentId",studentId);
		
		Student theStudent = (Student) query.getSingleResult(); 
		
		List<Course> theCourses = theStudent.getCourses();
		
		System.out.println(theCourses);
		
		return theCourses; 
		
		
	}
	
	
}
