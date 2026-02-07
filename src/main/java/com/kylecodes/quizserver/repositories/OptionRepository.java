package com.kylecodes.quizserver.repositories;

import com.kylecodes.quizserver.entities.Option;
import com.kylecodes.quizserver.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
    List<Option> findAllByQuestion(Question question);
}
