package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;

@Controller
public class AnswersController {
	
	private final AnswerService answerService;
	private final QuestionService questionService;
	
	public AnswersController(AnswerService answerService, QuestionService questionService) {
		this.answerService = answerService;
		this.questionService = questionService;
		
	}
	
	@RequestMapping("/answers")
	public String index(Model model) {
		List<Answer> allAnswer = answerService.allAnswers();
		
		model.addAttribute("answers", allAnswer);
		return "/answers/index.jsp";
		
	}
	
	@RequestMapping("/answers/create")
	public String create(Model model, @ModelAttribute("answer") Answer answer) {
		List<Question> allQuestion = questionService.allQuestions();
		
		model.addAttribute("questions", allQuestion);
		return "/answers/create.jsp";
		
	}
	
	@RequestMapping(value="/answers", method=RequestMethod.POST)
	public String createAnswers(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		
		
		System.out.println("Answer");
		if (result.hasErrors()) {
            return "/answers/create.jsp";
        } else {
        	answerService.addAnswer(answer);
            return "redirect:/answers";
        }
		
	}

}
