package com.kylecodes.quizserver.repositories;

import com.kylecodes.quizserver.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Repository adds the class to Spring's IOc Container and adds mysql error translation
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findQuizById(Integer id);
}
