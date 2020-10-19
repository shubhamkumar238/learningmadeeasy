package com.learningmadeeasy.service;

import java.util.List;

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

}
