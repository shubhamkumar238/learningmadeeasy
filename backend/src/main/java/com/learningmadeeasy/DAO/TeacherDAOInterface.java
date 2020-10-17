package com.learningmadeeasy.DAO;

import com.learningmadeeasy.entity.Teacher;

public interface TeacherDAOInterface {

	void save(Teacher theTeacher);

	Teacher findTeacherById(int teacherId);

}
