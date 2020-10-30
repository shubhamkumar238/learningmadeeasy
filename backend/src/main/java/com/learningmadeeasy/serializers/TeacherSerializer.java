package com.learningmadeeasy.serializers;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learningmadeeasy.entity.TeacherDetails;

@SuppressWarnings("serial")
@JsonComponent
public class TeacherSerializer extends StdSerializer<TeacherDetails>{
	public TeacherSerializer() {
        this(null);
    }
  
    public TeacherSerializer(Class<TeacherDetails> t) {
        super(t);
    }
 
	@Override
	public void serialize(TeacherDetails value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("about", value.getAbout());
		gen.writeStringField("achievements", value.getAchievements());
		gen.writeStringField("myObjectives", value.getMyobjectives());
		gen.writeStringField("expertCategory", value.getExpertCategory());
		gen.writeEndObject();
	}
}
