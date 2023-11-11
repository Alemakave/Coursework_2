package ru.alemakave.coursework_2.examinerservice.service;

import ru.alemakave.coursework_2.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
