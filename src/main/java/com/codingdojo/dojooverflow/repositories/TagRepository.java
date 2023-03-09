package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
    // Retrieves a list of all categories for a particular product
    List<Tag> findAllByQuestions(Question question);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Tag> findByQuestionsNotContains(Question question);
    
    Boolean existsByNameContaining(String search);
	
}
