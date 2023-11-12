package ru.alemakave.coursework_2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.alemakave.coursework_2.examinerservice.domain.Question;
import ru.alemakave.coursework_2.examinerservice.exception.OutOfBoundsException;
import ru.alemakave.coursework_2.examinerservice.service.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.alemakave.coursework_2.examinerservice.service.utils.TestUtils.javaQuestionServiceGetAll;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @InjectMocks
    private ExaminerServiceImpl examService;

    @Test
    public void getQuestions_Success() {
        when(javaQuestionService.getAll()).thenReturn(javaQuestionServiceGetAll());
        when(javaQuestionService.getRandomQuestion()).thenCallRealMethod();
        when(javaQuestionService.getRandom()).thenCallRealMethod();

        List<Question> expectedResult = new ArrayList<>(examService.getQuestions(6));

        List<Question> actualResult = new ArrayList<>(TestUtils.javaQuestionServiceGetAll());

        assertEquals(expectedResult.size(), 6);
        for (Question question : expectedResult) {
            assertTrue(actualResult.contains(question));
        }
    }

    @Test
    void getQuestions_OutOfBoundsException() {
        assertThrows(OutOfBoundsException.class, () -> examService.getQuestions(1));
    }
}