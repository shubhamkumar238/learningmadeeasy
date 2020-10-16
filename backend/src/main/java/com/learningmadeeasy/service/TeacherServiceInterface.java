package com.learningmadeeasy.service;

import com.learningmadeeasy.entity.Teacher;

public interface TeacherServiceInterface {

	void save(Teacher theTeacher);

	Teacher findTeacherById(int TeacherId);

}
