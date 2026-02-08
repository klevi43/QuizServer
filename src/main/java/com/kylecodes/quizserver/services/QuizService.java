package com.kylecodes.quizserver.services;

import com.kylecodes.quizserver.entities.Quiz;
import com.kylecodes.quizserver.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz getQuizById(Integer id) throws Exception {
        Optional<Quiz> quiz = quizRepository.findQuizById(id);
        if (quiz.isEmpty()) {
            throw new Exception("Quiz not found");
        }
        return quiz.get();
    }
}
