package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> allQuestions(){
		
		return questionRepository.findAll();
	}
	
	public Question addQuestion(Question question) {
		
		return questionRepository.save(question);
		
	}
	
	public List<Question> findNotContainTags(Tag tag){
		   List<Question> findNot = questionRepository.findByTagsNotContains(tag);
		   return findNot;
		   
	}
	   
	public List<Question> findContainTag(Tag tag){
	   List<Question> findOne = questionRepository.findAllByTags(tag);
	   return findOne;
	}

}
