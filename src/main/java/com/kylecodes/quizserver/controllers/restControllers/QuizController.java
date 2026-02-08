package com.kylecodes.quizserver.controllers.restControllers;

import com.kylecodes.quizserver.entities.Quiz;
import com.kylecodes.quizserver.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/quiz/get")
    public Quiz getQuizById(@RequestParam Integer id) throws Exception {
        return quizService.getQuizById(id);
    }
}
