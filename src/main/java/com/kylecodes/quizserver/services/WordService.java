package com.kylecodes.quizserver.services;

import com.kylecodes.quizserver.entities.Word;
import com.kylecodes.quizserver.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAll() {
        return wordRepository.findAll();
    }
}
