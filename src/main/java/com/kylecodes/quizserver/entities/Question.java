package com.kylecodes.quizserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String content;
    @ManyToOne()
    @JoinColumn
    @NotNull
    private Quiz quiz;

    @OneToMany(orphanRemoval = true, mappedBy = "question", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Option> options;


    private Integer correctOptionId;

    public Question() {
    }

    public Question(Integer id, String content, Quiz quiz, List<Option> options, Integer correctOptionId) {
        this.id = id;
        this.content = content;
        this.quiz = quiz;
        this.options = options;
        this.correctOptionId = correctOptionId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Integer getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(Integer correctOptionId) {
        this.correctOptionId = correctOptionId;
    }
}
