package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
    // Retrieves a list of all categories for a particular product
    List<Question> findAllByTags(Tag tag);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Question> findByTagsNotContains(Tag tag);
    
    List<Question> findByAnswersNotContains(Answer answer);

}
