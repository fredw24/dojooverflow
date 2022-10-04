package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;


@Service
public class TagService {
	
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository){
		this.tagRepository = tagRepository;
		
	}
	
	public Tag addTag(Tag tag) {
		
		return tagRepository.save(tag);
		
	}
	
	public List<Tag> findNotContainQuestion(Question question){
		   List<Tag> findNot = tagRepository.findByQuestionsNotContains(question);
		   return findNot;
		   
	}
	   
	public List<Tag> findContainCategory(Question question){
	   List<Tag> findOne = tagRepository.findAllByQuestions(question);
	   return findOne;
	}

}
