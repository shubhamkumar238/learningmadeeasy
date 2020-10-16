package com.learningmadeeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.TeacherDAOInterface;
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
	public Teacher findTeacherById(int teacherId) {
		return teacherDAOInterface.findTeacherById(teacherId);
	}
	
	

}
