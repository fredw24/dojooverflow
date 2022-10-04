package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.QuestionService;


@Controller
public class QuestionsController {

	private final QuestionService questionService;
	public QuestionsController(QuestionService questionService) {
		this.questionService = questionService;
		
	}
	
	@RequestMapping("/questions")
	public String index(Model model) {
		List<Question> allQuestions = questionService.allQuestions();

		
		model.addAttribute("questions", allQuestions);
		return "/questions/index.jsp";
		
	}
	
	@RequestMapping("/questions/create")
	public String CreateQuestion(@ModelAttribute("question") Question question) {

		return "/questions/create.jsp";
		
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if (result.hasErrors()) {
            return "/questions/create.jsp";
        } else {
        	questionService.addQuestion(question);
            return "redirect:/questions";
        }
    }
}
