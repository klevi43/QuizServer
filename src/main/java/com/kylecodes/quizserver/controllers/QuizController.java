package com.kylecodes.quizserver.controllers;

import com.kylecodes.quizserver.entities.Question;
import com.kylecodes.quizserver.entities.Quiz;
import com.kylecodes.quizserver.services.QuestionService;
import com.kylecodes.quizserver.services.QuizService;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class QuizController {
    private final QuestionService questionService;


    private final SimpMessagingTemplate template;
    private final SimpUserRegistry simpUserRegistry;
    private QuizService quizService;
    public QuizController(QuizService quizService, QuestionService questionService, SimpMessagingTemplate template, SimpUserRegistry simpUserRegistry) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.template = template;
        this.simpUserRegistry = simpUserRegistry;
    }

    @MessageMapping("/send-quiz")
    @SendTo("/quiz/get-quiz")
    public Quiz getQuiz(@RequestBody Integer quizId) {
        System.out.println(quizId);
        return quizService.getQuizById(quizId);
    }
    @MessageMapping("/receive-answer") // Frontend calls here
    @SendTo("/quiz/answer") // Server sends event here
    public List<Question> echo(@Header("simpSessionId") String sessionId) {
        return questionService.getAll();
        //template.convertAndSendToUser(sessionId, "/answer", "test");
    }
}
