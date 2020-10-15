package com.learningmadeeasy.DAO;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAOInterface {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Teacher theTeacher) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theTeacher);
		
	}

}
