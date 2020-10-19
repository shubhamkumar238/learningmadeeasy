
package com.learningmadeeasy.DAO;

import java.util.List;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

public interface TeacherDAOInterface {

	void save(Teacher theTeacher);
  
  Teacher findTeacherById(int teacherId);

	List<Course> allCoursesOfTeacher(int teacherId);

}
