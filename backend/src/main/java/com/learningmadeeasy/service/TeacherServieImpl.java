package com.learningmadeeasy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.TeacherDAOInterface;
import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

@Service
public class TeacherServieImpl implements TeacherServiceInterface {
	
	@Autowired
	private TeacherDAOInterface teacherDAOInterface;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Teacher theTeacher) {
		teacherDAOInterface.save(theTeacher);
	}

	@Override
	@Transactional
	public List<Course> allCoursesOfTeacher(int teacherId) {
		return teacherDAOInterface.allCoursesOfTeacher(teacherId);
    }

	@Override
	public Teacher findTeacherById(int TeacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public Map<String,Object> teacherRating(int teacherId){
		
		List<Course> theCourses = teacherDAOInterface.teacherRating(teacherId);
		
		int sz = theCourses.size();
		
		float teacherRating = 0;
		int count = 0;
		
		System.out.println("testing: " + theCourses);
		
		for(int i=0;i<sz;i++) {
			
			Course currCourse = theCourses.get(i);
			int currCourseId = currCourse.getCourseId();
			Object courseRating = entityManager.createQuery("select sum(courseRating) from Rating where courseId=:courseId group by courseId")
						.setParameter("courseId", currCourseId).getSingleResult();
			
			Object tempResult = entityManager.createQuery("select count(courseRating) from Rating where courseId=:courseId group by courseId")
							.setParameter("courseId", currCourseId).getSingleResult();

			teacherRating+=(Long)courseRating;
			
			count+=(Long)tempResult;
			
		}
		
		teacherRating/=count;
		
		Map<String,Object> finalTeacherRating = new HashMap<>();
		
		
		
		finalTeacherRating.put("Teacher with Teacher id", teacherRating);
		
		//System.out.println("DEBUGGING : " + finalTeacherRating);
		return finalTeacherRating;
	}
	
	@Override
	@Transactional
	public Map<String,Object> topTeachers(){
		
		List<Teacher> theTeachersId = teacherDAOInterface.topTeachers();
		
		int size = theTeachersId.size();
		int theTeacherRating = 0;
		
		for(int i=0;i<size;i++) {
			
			theTeacherRating = 0;
			
			List<Course> theCourses = entityManager.createQuery("from Course where courseId=:courseId")
								.setParameter("courseId", theTeachersId.get(i).getCourses()).getResultList();
			
			for(int j=0;j<theCourses.size();j++) {
				
				Object tempResult = entityManager.createQuery("select avg(courseRating) from Rating where courseId=:courseId")
							.setParameter("courseId", theCourses.get(j).getCourseId()).getSingleResult();
				
				theTeacherRating+=(Long)tempResult;
				
			}
			
			float thisTeacherRating = theTeacherRating/theCourses.size();
			
			theTeachersId.get(i).setTeacherRating(thisTeacherRating);
			
			System.out.println("teacher with teacher id :" + theTeachersId.get(i).getTeacherId() + " has rating - " + theTeachersId.get(i).getTeacherRating());
			
			
		}
		return null;
		
			
		
	}

}
