package com.kylecodes.quizserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class QuizController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/answer")
    public void echo(@Header("simpSessionId") String sessionId) {
        template.convertAndSendToUser(sessionId, "answer-result", "test");
    }
}
