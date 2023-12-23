package pro.sky.skyprocoursework2.examinerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;
import pro.sky.skyprocoursework2.examinerservice.service.JavaQuestionService;
import pro.sky.skyprocoursework2.examinerservice.service.QuestionService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    QuestionService out = new JavaQuestionService();

    private final Question QUESTION1 = new Question("Прогресс1", "Корпус1");
    private final Question QUESTION2 = new Question("Прогресс2", "Корпус2");
    private final Question QUESTION3 = new Question("Прогресс3", "Корпус3");

    @Test
    public void addTest() {
        assertEquals(out.add("Прогресс1", "Корпус1"), QUESTION1);
        out.add("Прогресс2", "Корпус2");
        assertTrue(out.getAll().contains(QUESTION2));
        assertFalse(out.getAll().contains(QUESTION3));

    }

    @Test
    public void addOnThrowTest() {
        out.add("Прогресс2", "Корпус2");
        assertThrows(IllegalArgumentException.class, () -> out.add("Прогресс2", "Корпус2"));
    }

    @Test
    public void removeTest() {
        out.add("Прогресс1", "Корпус1");
        assertTrue(out.remove(new Question("Прогресс1", "Корпус1"))
                .equals(new Question("Прогресс1", "Корпус1")));
        assertThrows(IllegalArgumentException.class, () -> out.find("Прогресс1"));

    }

    @Test
    public void findTest() {
        out.add("Прогресс1", "Корпус1");
        assertEquals(out.find("Прогресс1"),
                new Question("Прогресс1", "Корпус1"));
        assertThrows(IllegalArgumentException.class,
                () -> out.find("Прогресс2"));
    }


}

