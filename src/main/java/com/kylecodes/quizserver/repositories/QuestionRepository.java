package com.kylecodes.quizserver.repositories;


import com.kylecodes.quizserver.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findWordById(Question question);
}
