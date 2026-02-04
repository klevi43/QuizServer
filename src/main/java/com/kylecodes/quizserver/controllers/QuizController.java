package com.kylecodes.quizserver.controllers;

import com.kylecodes.quizserver.entities.Word;
import com.kylecodes.quizserver.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QuizController {
    private final WordService wordService;


    private final SimpMessagingTemplate template;

    public QuizController(WordService wordService, SimpMessagingTemplate template) {
        this.wordService = wordService;
        this.template = template;
    }

    @MessageMapping("/receive-answer") // Frontend calls here
    @SendTo("/quiz/answer") // Server sends event here
    public List<Word> echo(@Header("simpSessionId") String sessionId) {
        return wordService.getAll();
        //template.convertAndSendToUser(sessionId, "/answer", "test");
    }
}
