package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;


@Service
public class TagService {
	
	private final TagRepository tagRepository;
	private final QuestionRepository questionRepository;
	
	public TagService(TagRepository tagRepository, QuestionRepository questionRepository){
		this.tagRepository = tagRepository;
		this.questionRepository = questionRepository;
		
	}
	
	public Boolean containTag(Tag tag) {
		return tagRepository.existsByNameContaining(tag.getName());
		
	}
	
	public Tag addTag(Tag tag) {
		
		return tagRepository.save(tag);
		
	}
	
	public List<Tag> findAll(){
		
		return tagRepository.findAll();
	}
	
	public List<Tag> findNotContainQuestion(Question question){
		   List<Tag> findNot = tagRepository.findByQuestionsNotContains(question);
		   return findNot;
		   
	}
	   
	public List<Tag> findContainQuestion(Question question){
	   List<Tag> findOne = tagRepository.findAllByQuestions(question);
	   return findOne;
	}

}
