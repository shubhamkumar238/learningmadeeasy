package com.learningmadeeasy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAOInterface {
	
	@Autowired
	private EntityManager entityManager;
		
	@Override
	public List<Course> showAllCourses(){
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("from Course", Course.class);
		
		//execute query and get result list
		List<Course> players = theQuery.getResultList();
		
		return players;
	}
	
	@Override
	public Course showParticularCourse(int courseId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course theCourse = currentSession.get(Course.class, courseId);
		
		return theCourse;
	}
	
	@Override
	public void save(Course theCourse) {
		
		//get the current hibernate session
		Session currentSession  = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCourse);
	}
	
}
