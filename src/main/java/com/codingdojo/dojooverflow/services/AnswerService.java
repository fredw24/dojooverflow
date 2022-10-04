package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;


@Service
public class AnswerService {
	
private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> allAnswers(){
		
		return answerRepository.findAll();
	}
	
	public Answer addAnswer(Answer answer) {
		
		return answerRepository.save(answer);
		
	}
	
	public List<Answer> findNotContainQuestion(Question question){
		   List<Answer> findNot = answerRepository.findByQuestionNotContains(question);
		   return findNot;
		   
	}
	   
	public List<Answer> findContainQuestion(Question question){
	   List<Answer> findOne = answerRepository.findAllByQuestion(question);
	   return findOne;
	}
	   

}
