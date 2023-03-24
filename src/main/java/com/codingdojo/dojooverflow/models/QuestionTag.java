package com.codingdojo.dojooverflow.models;

import java.util.Date;

// the import * will save up spaces on the java classes 
import javax.persistence.*;

@Entity
@Table(name="questions_tag")
public class QuestionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    //begin joins
    // This is what I had before Jon Friend showed me
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="question_id")
//    private Question question;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="tag_id")
//    private Tag tag;
    // This what came after Jon Friend
    
    
    
    
    
    
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    
    //end joins
    
    
    public QuestionTag() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //begin getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}



    
    //end getter and setter
}// end model
