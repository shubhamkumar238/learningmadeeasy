package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Video;

@Repository
public class VideoDAOImpl implements VideoDAOInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void saveTheVideo(Map<String, ?> video) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String videoUrl = (String) video.get("video_url");
		int courseId = (int)video.get("course_id");
		
		Course currentCourse = currentSession.get(Course.class, courseId);
		
		Video videoObject = new Video(videoUrl);
		currentSession.save(videoObject);
		currentCourse.addVideo(videoObject);
	}

	@Override
	public List<Video> theCourseVideo(int courseId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course currentCourse = currentSession.get(Course.class, courseId);
		List<Video> response = currentCourse.getVideos();
		return response;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		Query query = entityManager.createQuery("select c from Course c", Course.class);
		List<Course> responseList = query.getResultList();
		return responseList;
	}

}
