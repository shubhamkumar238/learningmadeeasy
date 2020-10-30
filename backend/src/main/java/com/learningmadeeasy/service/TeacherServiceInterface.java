package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;

public interface TeacherServiceInterface {

	  void save(Teacher theTeacher);

	  String allCoursesOfTeacher(int teacherId);
  
    Teacher findTeacherById(int TeacherId);

	  String top10Teachers();

    String getAllTeachers();

    String getTeacherDetail(int teacherId);

}