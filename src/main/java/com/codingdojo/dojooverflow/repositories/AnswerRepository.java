package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	
	List<Answer> findAll();
    // Retrieves a list of all categories for a particular product
    List<Answer> findAllByQuestion(Question question);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Answer> findByQuestionNotContains(Question question);
	

}
