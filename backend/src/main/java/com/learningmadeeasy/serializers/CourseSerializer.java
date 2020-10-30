package com.learningmadeeasy.serializers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class CourseSerializer{
	
	public String serilizationOfCourse(List<Object[]> info) {
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		
		for(int i=0;i<info.size();i++) {
			ObjectNode objectNode1 = mapper.createObjectNode();
			Object[] row = info.get(i);
	        objectNode1.put("courseId", (int)row[0]);
	        objectNode1.put("courseName", (String)row[1]);
	        objectNode1.put("teacherName", (String)row[2]);
	        objectNode1.put("studentCount", (BigInteger)row[3]);
	        objectNode1.put("noOfRatings", (BigInteger)row[4]);
	        
	        if(row[5]==null)
	        	objectNode1.put("averageRating", 0);
	        else
	        	objectNode1.put("averageRating", (BigDecimal)row[5]);
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
