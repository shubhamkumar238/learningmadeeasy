package com.learningmadeeasy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAOInterface {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Teacher theTeacher) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theTeacher);
		
	}

	@Override
	public List<Course> allCoursesOfTeacher(int teacherId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Teacher currentTeacher = currentSession.get(Teacher.class, teacherId);
		List<Course> response = currentTeacher.getCourses();
		return response;
	}
  
  @Override
	public Teacher findTeacherById(int teacherId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Teacher
		Teacher theTeacher  = currentSession.get(Teacher.class, teacherId);
		
		return theTeacher;
		
	}
  
  @Override
  @Transactional
  public List<Course> teacherRating(int teacherId){
	  
	  Teacher theTeacher = (Teacher) entityManager.createQuery("from Teacher where teacherId=:teacherId")
			  					.setParameter("teacherId", teacherId).getSingleResult();
	  List<Course> theCourses = theTeacher.getCourses();
	  
	  System.out.println("testingin DAO " + theCourses);
	  
	  return theCourses;
	  
  }
  
  	@Override
	public List<Teacher> topTeachers(){
		
		List<Teacher> teachersId = entityManager.createQuery("from Teacher").getResultList();
		
		return teachersId;
	}

}