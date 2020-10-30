package com.learningmadeeasy.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseCategoryDAOImpl implements CourseCategoryDAOInterface {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Object[]> showCategories(){
		
		String query = "select c.course_category_name,c.course_url";
		List<Object[]> resultset  = entityManager.createQuery("select c.courseCategory,COUNT(c.courseId), cc.categoryUrl from Course c  join CourseCategory cc ON cc.courseCategoryName=c.courseCategory GROUP BY c.courseCategory",Object[].class)
												 .getResultList();
		
		
		return resultset;
	}
	
	@Override
	public List<Object[]> studentsEnrolled(){
		
		List<Object[]> resultset = entityManager.createQuery("select courseId,COUNT(studentId) from CourseStudent GROUP BY courseId").getResultList();
		return resultset;
		
	}
	
	@Override
	public List<Object[]> countofEnrolledCourseCategory(String courseCategoryName) {
		
		List<Object[]> resultset = entityManager.createQuery("select courseId,COUNT(studentId) from CourseStudent GROUP BY courseId").getResultList();
		
		
		return resultset;
	}

	@Override
	public List<Object[]> getAllCoursesForThisCategory(String categoryName) {
		
		List<Object[]> resultset = entityManager.createQuery("select courseId,courseName from Course where courseCategory=:courseCategory")
									.setParameter("courseCategory", categoryName).getResultList();
		
		return resultset;
	}
	
}
