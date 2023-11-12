package ru.alemakave.coursework_2.examinerservice.service.utils;

import ru.alemakave.coursework_2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;

public class TestUtils {
    public static Collection<Question> javaQuestionServiceGetAll() {
        HashSet<Question> questions = new HashSet<>();

        questions.add(new Question("Q1", "A1"));
        questions.add(new Question("Q2", "A2"));
        questions.add(new Question("Q3", "A3"));
        questions.add(new Question("Q4", "A4"));
        questions.add(new Question("Q5", "A5"));
        questions.add(new Question("Q6", "A6"));
        questions.add(new Question("Q7", "A7"));
        questions.add(new Question("Q8", "A8"));
        questions.add(new Question("Q9", "A9"));

        return questions;
    }
}
