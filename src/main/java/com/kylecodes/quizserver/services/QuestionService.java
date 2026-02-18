package com.kylecodes.quizserver.services;

import com.kylecodes.quizserver.entities.Question;
import com.kylecodes.quizserver.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }
    public Optional<Question> getById(Integer id) {
        return questionRepository.findQuestionById(id);
    }
}
