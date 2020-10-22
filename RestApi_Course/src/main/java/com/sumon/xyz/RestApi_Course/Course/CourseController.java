package com.sumon.xyz.RestApi_Course.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumon.xyz.RestApi_Course.Topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//Get All Topic;
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}
	
	//Get Specific Id;
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		
		return courseService.getcourse(id);
	}
	
	
	//Add Topic;
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.addCourse(course);
	}
	
	//Update Method;
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId,@PathVariable String id)
	{
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.updateCourse(course);
	}
	
	
	//Delete Method;
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		
		courseService.deleteCourse(id);
	}
	
	
}
