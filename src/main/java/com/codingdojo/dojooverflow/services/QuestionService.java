package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;


@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final TagRepository  tagRepository;
	
	public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository, TagRepository tagRepository) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.tagRepository = tagRepository;
	}
	
	public List<Question> allQuestions(){
		
		return questionRepository.findAll();
	}
	
	public Question addQuestion(Question question) {
		
		return questionRepository.save(question);
		
	}
	
	public Question findById(Long id) {
		Optional<Question> oneQuestion = questionRepository.findById(id);
		
		if (oneQuestion.isPresent()) {
		
			return oneQuestion.get();
		}
		else {
			return null;
		}
	}
	
	public List<Question> findNotContainTags(Tag tag){
		   List<Question> findNot = questionRepository.findByTagsNotContains(tag);
		   return findNot;
		   
	}
	   
	public List<Question> findContainTag(Tag tag){
	   List<Question> findOne = questionRepository.findAllByTags(tag);
	   return findOne;
	}
	
	public void linkTag(Long questionId, Long tagId) {
		
		// retrieve an instance of a category using another method in the service.
	    Optional<Question> thisQuestion = questionRepository.findById(questionId);
	    
	    // retrieve an instance of a product using another method in the service.
	    Optional<Tag> thisTag = tagRepository.findById(tagId);
	    
	    // add the product to this category's list of products
	    thisQuestion.get().getTags().add(thisTag.get());
	    
	    // Save thisCategory, since you made changes to its product list.
	    questionRepository.save(thisQuestion.get());
	}

}
