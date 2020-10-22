package com.sumon.xyz.RestApi_Course.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	/*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("1","Sumon","computer science and engineering"),
			new Topic("2","Khair","computer science and engineering"),
			new Topic("3","Sujit","computer science and engineering")
			)); */
	

	//Get All Topic;
	public List<Course> getAllCourses(String topicId)
	{
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		
		
	}
	
	
	//Get Specific Id;
	public Course getcourse(String id)
	{
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		
		Course t =null;
		Optional<Course> options = courseRepository.findById(id);
		if(options.isPresent()) {
			t = options.get();
		}
		
		return t;
		
	}


	//Add Topic;
	public void addCourse(Course course) {
		
		//topics.add(topic);
		courseRepository.save(course);
		
		
	}

	
    //Update Method;
	public void updateCourse(Course course) {
		
	/*	for(int i=0; i<topics.size(); i++)
		{
			Topic t = topics.get(i);
			//Check Message;
			System.out.println("Message i :"+t);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}*/
		
		courseRepository.save(course);
		
		
	}


	//Delete Method;
	public void deleteCourse(String id) {
		
		//topics.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
		
		
	}
	
	
}
