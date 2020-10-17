package com.learningmadeeasy.service;

import java.util.List;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

public interface TeacherServiceInterface {

	void save(Teacher theTeacher);

	List<Course> allCoursesOfTeacher(int teacherId);

}
