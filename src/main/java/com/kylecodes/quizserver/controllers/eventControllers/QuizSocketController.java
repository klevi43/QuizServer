package com.kylecodes.quizserver.controllers.eventControllers;

import com.kylecodes.quizserver.dtos.AnswerDto;
import com.kylecodes.quizserver.entities.Question;
import com.kylecodes.quizserver.entities.Quiz;
import com.kylecodes.quizserver.services.QuestionService;
import com.kylecodes.quizserver.services.QuizService;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class QuizSocketController {
    private final QuestionService questionService;


    private final SimpMessagingTemplate template;
    private final SimpUserRegistry simpUserRegistry;
    private QuizService quizService;
    public QuizSocketController(QuizService quizService, QuestionService questionService, SimpMessagingTemplate template, SimpUserRegistry simpUserRegistry) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.template = template;
        this.simpUserRegistry = simpUserRegistry;
    }

    @MessageMapping("/receive-answer")
    public void validateAnswer(@Payload AnswerDto answerDto) throws Exception {

        System.out.println("Message from: " + answerDto.getFrom());
        Optional<Question> question = questionService.getById(answerDto.getQuestionId());
        if (question.isEmpty()) {
            throw new Exception("Question not found");
        }

        template.convertAndSend("/queue/answer-result/" + answerDto.getFrom(), answerDto.getOptionId().equals(question.get().getCorrectOptionId()));
    }
//    @MessageMapping("/receive-answer") // Frontend calls here
//    @SendTo("/quiz/answer") // Server sends event here
//    public List<Question> echo(@Header("simpSessionId") String sessionId) {
//        return questionService.getAll();
//        //template.convertAndSendToUser(sessionId, "/answer", "test");
//    }
}
