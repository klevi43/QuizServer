package com.kylecodes.quizserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "quiz", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnore
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(Integer id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
