package pro.sky.skyprocoursework2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;
import pro.sky.skyprocoursework2.examinerservice.service.ExaminerServiceIml;
import pro.sky.skyprocoursework2.examinerservice.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceIml out;

    private static final Question QUESTION1 = new Question("Прогресс1", "Корпус1");
    private static final Question QUESTION2 = new Question("Прогресс2", "Корпус2");
    private static final Question QUESTION3 = new Question("Прогресс3", "Корпус3");
    private static final Question QUESTION4 = new Question("Прогресс4", "Корпус4");
    private static final Question QUESTION5 = new Question("Прогресс5", "Корпус5");




    @Test
    public void getQuestionTestOnThrow(){
      when(questionService.size()).thenReturn(2);
       assertThrows(IllegalArgumentException.class, ()->out.getQuestion(3));
    }

    @Test
    public void getQuestionTest(){
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2,QUESTION3,QUESTION4,QUESTION5);
        when(questionService.size()).thenReturn(10);
        assertEquals(out.getQuestion(5).size(),5);
    }

    @Test
    public void getQuestionTestOnContains(){
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2,QUESTION3,QUESTION4,QUESTION5);
        when(questionService.size()).thenReturn(10);
        assertTrue(out.getQuestion(5).contains(QUESTION3));
    }





}
