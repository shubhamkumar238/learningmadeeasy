package com.learningmadeeasy.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learningmadeeasy.entity.Video;

@Repository
public class VideoDAOImpl implements VideoDAOInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void saveTheVideo(Video video) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(video);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> theCourseVideo(int courseId) {
		List<String> responseList = null;
		
		Query query = entityManager.createQuery("select videoUrl from Video where courseId=:courseId");
		query.setParameter("courseId", courseId);	
		
		responseList = query.getResultList();
		return responseList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAllCourses() {
		List<Integer> responseList = null;
		Query query = entityManager.createQuery("select courseId from Course");
		responseList = query.getResultList();
		return responseList;
	}

}
