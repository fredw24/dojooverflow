package com.codingdojo.dojooverflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="question_id")
//    @JsonIgnore // making sure that it does not do json endless loop call
//    private Question question;
    
    

	public Answer() {
		
	}

// start getter and setters

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



//	public Question getQuestion() {
//		return question;
//	}
//
//
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}

//end getter and setters

}// end model
