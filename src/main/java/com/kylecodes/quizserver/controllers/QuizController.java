package com.kylecodes.quizserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class QuizController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/receive-answer")
    @SendTo("/quiz/answer")
    public String echo(@Header("simpSessionId") String sessionId) {
        return "Testaldkfja";
        //template.convertAndSendToUser(sessionId, "/answer", "test");
    }
}
