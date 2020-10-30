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
	public List<Object[]> showAllCourses(){
		
		String nativeSqlQuery = "select c.course_id, c.course_name, t.name , (select count(*) from course_student cs  where cs.course_id=c.course_id ), \r\n" + 
				"(select count(*) from review_course cr  where cr.course_id=c.course_id ), (select avg(cr.rating) from review_course cr  where cr.course_id=c.course_id )\r\n" + 
				" from course c join \r\n" + 
				"teacher t on t.teacher_id=c.teacher_id";
		List<Object[]> response= entityManager.createNativeQuery(nativeSqlQuery).getResultList();
		
		return response;
		
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCourseFeatures(int courseId) {
		
		String sqlQuery = "select tableA.course_id,  tableA.totalDuration, tableA.totalLectures, tableB.totalStudents\r\n" + 
				"from\r\n" + 
				"(\r\n" + 
				"	select v.course_id, sum(v.duration) totalDuration, count(*) totalLectures  from video v where v.course_id=:courseId group by v.course_id\r\n" + 
				") tableA\r\n" + 
				"INNER JOIN \r\n" + 
				"(\r\n" + 
				"	select c.course_id, count(*) totalStudents  from course_student c where c.course_id=:courseId group by c.course_id\r\n" + 
				") tableB on (tableA.course_id=tableB.course_id)";
		Query query = entityManager.createNativeQuery(sqlQuery);
		query.setParameter("courseId", courseId);
		
		List<Object[]> teacherDetails = query.getResultList();
		return teacherDetails;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getSimilarCourseForCategory(String courseCategory) {
		String nativeSqlQuery = "select c.course_id, c.course_name, t.name , (select count(*) from course_student cs  where cs.course_id=c.course_id ), \r\n" + 
				"(select count(*) from review_course cr  where cr.course_id=c.course_id ), (select avg(cr.rating) from review_course cr  where cr.course_id=c.course_id )\r\n" + 
				" from course c join \r\n" + 
				"teacher t on t.teacher_id=c.teacher_id where c.course_category=:courseCategory";
		
		Query query = entityManager.createNativeQuery(nativeSqlQuery);
		query.setParameter("courseCategory", courseCategory);
		List<Object[]> response= query.getResultList();
		
		return response;
	}
	
}
