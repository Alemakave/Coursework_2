package ru.alemakave.coursework_2.examinerservice.service;

import org.springframework.stereotype.Service;
import ru.alemakave.coursework_2.examinerservice.domain.Question;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);

        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return (Question) getAll().toArray()[random.nextInt(getAll().size())];
    }

    @PostConstruct
    private void postLoad() {
        int questionCount = 25;

        Random subRand = new Random(20231109);
        for (int i = 0; i < questionCount; i++) {
            add("Question " + subRand.nextInt(questionCount), "Answer " + subRand.nextInt(questionCount));
        }
    }
}
