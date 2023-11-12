package ru.alemakave.coursework_2.examinerservice.service;

import org.springframework.stereotype.Service;
import ru.alemakave.coursework_2.examinerservice.domain.Question;
import ru.alemakave.coursework_2.examinerservice.exception.OutOfBoundsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new OutOfBoundsException("Количество запрашиваемых вопросов должно быть меньше чем количество вопросов всего!");
        }

        Set<Question> questions = new HashSet<>(amount);

        while (questions.size() < amount) {
            questions.add(service.getRandomQuestion());
        }

        return questions;
    }
}
