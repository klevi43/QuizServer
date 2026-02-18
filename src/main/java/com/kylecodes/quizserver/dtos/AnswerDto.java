package com.kylecodes.quizserver.dtos;

public class AnswerDto {
    private String from;
    private Integer optionId;
    private Integer questionId;

    public AnswerDto(String from, Integer optionId, Integer questionId) {
        this.from = from;
        this.optionId = optionId;
        this.questionId = questionId;
    }

    public AnswerDto() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

}
