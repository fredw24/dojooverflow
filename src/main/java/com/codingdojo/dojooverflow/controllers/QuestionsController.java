package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;


@Controller
public class QuestionsController {

	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
	
	public QuestionsController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
		
	}
	
	@RequestMapping("/questions")
	public String index(Model model) {
		List<Question> allQuestions = questionService.allQuestions();

		
		model.addAttribute("questions", allQuestions);
		return "/questions/index.jsp";
		
	}
	
	@RequestMapping("/questions/create")
	public String CreateQuestion(@ModelAttribute("question") Question question, @ModelAttribute("tag") Tag tag) {

		return "/questions/create.jsp";
		
	}
	
	@RequestMapping("/questions/{id}")
	public String DetailQuestion(@ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, Model model) {
		
		Question oneQuestion = questionService.findById(id);
		
		model.addAttribute("question", oneQuestion);	
		
		
		return "/questions/detail.jsp";
		
	}
	
	@RequestMapping("/questions/{id}/tag")
	public String TagQuestion(@ModelAttribute("tag") Tag tag,@ModelAttribute("question") Question question, @PathVariable("id") Long id, Model model) {
		
		Question oneQuestion = questionService.findById(id);
		
		List<Tag> notTagList = tagService.findNotContainQuestion(oneQuestion);
		
		model.addAttribute("question", oneQuestion);	
		model.addAttribute("notTag", notTagList);
		
		if (oneQuestion.getTags().size() == 3) {
			return "redirect:/questions";
		}
		else {
			return "/questions/linktag.jsp";
			
		}
		
		
		
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
    public String linkTag( @Valid @ModelAttribute("question") Question question,@Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
		System.out.println("Create");
		if (result.hasErrors()) {
            return "/questions/create.jsp";
        } else {
        	
        	questionService.addQuestion(question);
            return "redirect:/questions";
        }
    }
	
	@RequestMapping(value="/questions/link", method=RequestMethod.POST)
    public String QuestionLink(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		System.out.println("LinkTag");
		if (result.hasErrors()) {
            return "/questions/linktag.jsp";
        } else {
        	
        	System.out.println(question.getId());
        	System.out.println(question.getTags().get(0).getId());
        		
        	questionService.linkTag(question.getId(), question.getTags().get(0).getId());
            return "redirect:/questions";
        }
    }
}
