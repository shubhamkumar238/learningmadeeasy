package com.learningmadeeasy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;
import com.learningmadeeasy.entity.TimeStamp;

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

}
