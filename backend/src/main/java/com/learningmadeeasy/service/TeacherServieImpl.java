package com.learningmadeeasy.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
	
	@Override
	public String top10Teachers(){
		
		List<Object[]> info = teacherDAOInterface.top10Teachers();
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		
		for(int i=0;i<info.size();i++) {
			ObjectNode objectNode1 = mapper.createObjectNode();
			Object[] row = info.get(i);
	        objectNode1.put("teacherName", (String)row[0]);
	        objectNode1.put("expertCategory", (String)row[1]);
	        objectNode1.put("courseCount", (BigInteger)row[2]);
	        
	        if(row[3]==null)
		        objectNode1.put("avgRating", 0);
	        else
	        	objectNode1.put("avgRating", (BigDecimal)row[3]);
   
	       
	        arrayNode.add(objectNode1);
		}
		
		String serialized = null;
		try {
			serialized = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return serialized;
	}
	
	
	
}
