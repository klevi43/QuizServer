package com.kylecodes.quizserver.controllers;

import com.kylecodes.quizserver.entities.Question;
import com.kylecodes.quizserver.services.QuestionService;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QuizController {
    private final QuestionService questionService;


    private final SimpMessagingTemplate template;

    public QuizController(QuestionService questionService, SimpMessagingTemplate template) {
        this.questionService = questionService;
        this.template = template;
    }

    @MessageMapping("/receive-answer") // Frontend calls here
    @SendTo("/quiz/answer") // Server sends event here
    public List<Question> echo(@Header("simpSessionId") String sessionId) {
        return questionService.getAll();
        //template.convertAndSendToUser(sessionId, "/answer", "test");
    }
}
