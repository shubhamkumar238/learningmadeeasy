package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.StudentDAOInterface;
import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Student;

@Service
public class StudentServiceImpl implements StudentServiceInterface {
	
	@Autowired
	private StudentDAOInterface studentDAOInterface;
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		
		studentDAOInterface.save(theStudent);
	}

	@Override
	@Transactional
	public int saveStudent(Map<String, ?> theStudent) {
		return studentDAOInterface.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public void savecourseforstudent(int studentId, int courseId) {
		studentDAOInterface.savecourseforstudent(studentId,courseId);
	}

	@Override
	public List<Course> getAllCourses(int studentId) {
		return studentDAOInterface.getAllCourses(studentId);
	}

}
