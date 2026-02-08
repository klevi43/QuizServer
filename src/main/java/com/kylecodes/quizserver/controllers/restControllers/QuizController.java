package com.kylecodes.quizserver.controllers.restControllers;

import com.kylecodes.quizserver.entities.Quiz;
import com.kylecodes.quizserver.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/get")
    public Quiz getQuizById(@RequestParam Integer id) {
        return quizService.getQuizById(id);
    }
}
