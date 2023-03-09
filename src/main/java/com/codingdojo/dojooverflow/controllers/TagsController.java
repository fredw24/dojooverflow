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
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class TagsController {
	
	private final TagService tagService;
	private final QuestionService questionService;
	public TagsController(TagService tagService, QuestionService questionService) {
	
		this.tagService = tagService;
		this.questionService = questionService;
	}
	
	@RequestMapping("/tags")
	public String index(Model model) {
		List<Tag> allTags = tagService.findAll();

		model.addAttribute("tags", allTags);
		return "/tags/index.jsp";
		
	}
	
	@RequestMapping("/tags/create")
	public String create(Model model, @Valid @ModelAttribute("tag") Tag tag) {
		
		
		return "/tags/create.jsp";
		
	}
	
	@RequestMapping(value="/tags", method=RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
		boolean check = tagService.containTag(tag);
		System.out.println(check);
		
		if (result.hasErrors()) {
            return "/tags/create.jsp";
        }
		else if (check) {
			
			return "/tags/create.jsp";
		}
		else {
        	tagService.addTag(tag);
            return "redirect:/tags";
        }
    }

}
