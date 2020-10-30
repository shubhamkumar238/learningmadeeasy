package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

@Repository
public class CourseDAOImpl implements CourseDAOInterface {
	
	@Autowired
	private EntityManager entityManager;
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> showAllCourses(){
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("from Course", Course.class);
		
		//execute query and get result list
		List<Course> courses = theQuery.getResultList();
		
		return courses;
	}
	
	@Override
	public Course showParticularCourse(int courseId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course theCourse = currentSession.get(Course.class, courseId);
		
		return theCourse;
	}

	@Override
	public int saveNewCourse(Map<String, ?> theCourse) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course newCourse = new Course();
		
		Query query = entityManager.createQuery("from Teacher where teacherId=:teacherId");
		query.setParameter("teacherId",(Integer) theCourse.get("teacherId"));
		
		Teacher theTeacher = (Teacher) query.getSingleResult();
		
		newCourse.setTeacher(theTeacher);
		
		newCourse.setCourseName((String)theCourse.get("courseName"));
		
		int generatedCourseId = (Integer) currentSession.save(newCourse);
		
		System.out.println("Generated Course Id- " + generatedCourseId);
		
		return newCourse.getCourseId();

	}
	
	@Override
	public List<Object[]> top10Courses(){
		
		String query = "select c.course_id, c.course_name, t.name , (select count(*) from course_student cs  where cs.course_id=c.course_id ), \r\n"
				+ "(select count(*) from review_course cr  where cr.course_id=c.course_id ) , (select avg(cr.rating) from review_course cr  where cr.course_id=c.course_id ) as avgRating\r\n"
				+ " from course c 	 join \r\n"
				+ "teacher t on t.teacher_id=c.teacher_id order by avgRating desc limit 10 ;";
		List<Object[]> resultSet = entityManager.createNativeQuery(query).getResultList();
		
		return resultSet;
		
	}


	
	
	
}
