package com.codingdojo.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import javax.persistence.JoinColumn;

@Entity
@Table(name="question")
public class Question {
	
	// tables for the Question
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    // link it with Question
    // this is the code that I had before Jon showed me
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "questions_tags", 
//        joinColumns = @JoinColumn(name = "question_id"), 
//        inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private List<Tag> tags;
    
    // many to many for Question to Tag respectively
    @OneToMany(mappedBy="Question", fetch = FetchType.LAZY)
    private List<QuestionTag> questionTagList;
    

//    // One to Many for question to answer respectively
//    @OneToMany(mappedBy="Question", fetch = FetchType.LAZY)
//    private List<Answer> answerList;
    
    public Question() {
    	
    	
    }
    // getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<QuestionTag> getQuestionTagList() {
		return questionTagList;
	}

	public void setQuestionTagList(List<QuestionTag> questionTagList) {
		this.questionTagList = questionTagList;
	}

//	public List<Answer> getAnswerList() {
//		return answerList;
//	}
//
//	public void setAnswerList(List<Answer> answerList) {
//		this.answerList = answerList;
//	}


    
    // end getter and setters
    
} //end model
