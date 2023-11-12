package ru.alemakave.coursework_2.examinerservice.service;

import org.junit.jupiter.api.Test;
import ru.alemakave.coursework_2.examinerservice.domain.Question;
import ru.alemakave.coursework_2.examinerservice.service.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    // add(String question, String answer)
    // add(Question question)
    @Test
    void add_Success() {
        Question question = new Question("Q1", "A1");
        assertEquals(service.add(question.getQuestion(), question.getAnswer()), question);
        assertEquals(service.add(question), question);
    }

    // remove(String question, String answer)
    // remove(Question question)
    @Test
    void remove_Success() {
        for (Question question : TestUtils.javaQuestionServiceGetAll()) {
            service.add(question);
        }

        Question question1 = new Question("Q1", "A1");
        Question question2 = new Question("Q2", "A2");

        assertEquals(service.remove(question1), question1);
        assertEquals(service.remove(question2.getQuestion(), question2.getAnswer()), question2);
    }

    @Test
    void getAll() {
        for (Question question : TestUtils.javaQuestionServiceGetAll()) {
            service.add(question);
        }

        assertEquals(service.getAll(), TestUtils.javaQuestionServiceGetAll());
    }

    @Test
    void getRandomQuestion() {
        for (Question question : TestUtils.javaQuestionServiceGetAll()) {
            service.add(question);
        }

        List<Question> questions = new ArrayList<>(TestUtils.javaQuestionServiceGetAll());

        for (int i = 0; i < questions.size(); i++) {
            assertTrue(questions.contains(service.getRandomQuestion()));
        }
    }
}