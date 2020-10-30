package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

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
  public List<Object[]> top10Teachers(){
	  
	  String query ="select t.name, td.expert_category, (select count(*) from Course c where c.teacher_id=t.teacher_id) , \r\n"
	  		+ "(select avg(rt.rating) from review_teacher rt where rt.teacher_id=t.teacher_id) teacher_score \r\n"
	  		+ "from teacher t join teacher_details td on td.teacher_details_id=t.teacher_details_id order by teacher_score desc limit 10";
	  
	  List<Object[]> resultSet = entityManager.createNativeQuery(query).getResultList();
		
	  return resultSet;
  }
  
  
  
  

}