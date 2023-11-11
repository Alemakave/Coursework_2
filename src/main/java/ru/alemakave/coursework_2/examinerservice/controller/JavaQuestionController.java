package ru.alemakave.coursework_2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alemakave.coursework_2.examinerservice.domain.Question;
import ru.alemakave.coursework_2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question add(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        return service.remove(question, answer);
    }

    @GetMapping("/")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
