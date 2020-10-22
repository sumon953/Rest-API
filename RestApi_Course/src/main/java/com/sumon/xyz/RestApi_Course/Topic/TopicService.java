package com.sumon.xyz.RestApi_Course.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	/*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("1","Sumon","computer science and engineering"),
			new Topic("2","Khair","computer science and engineering"),
			new Topic("3","Sujit","computer science and engineering")
			)); */
	

	//Get All Topic;
	public List<Topic> getAllTopic()
	{
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		
		
	}
	
	//Get Specific Id;
	public Topic getTopic(String id)
	{
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		Topic t =null;
		Optional<Topic> options = topicRepository.findById(id);
		if(options.isPresent()) {
			t = options.get();
		}
		
		return t;
		
	}


	//Add Topic;
	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		topicRepository.save(topic);
		
		
	}

	
    //Update Method;
	public void updateTopic(String id, Topic topic) {
		
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
		
		topicRepository.save(topic);
		
		
	}


	//Delete Method;
	public void deleteTopic(String id) {
		
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
		
		
	}
	
	
}
