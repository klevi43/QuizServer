package com.kylecodes.quizserver.services;

import com.kylecodes.quizserver.entities.Option;
import com.kylecodes.quizserver.entities.Question;
import com.kylecodes.quizserver.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Option> getOptionsForQuestion(Question question) {
        return optionRepository.findAllByQuestion(question);
    }
}
