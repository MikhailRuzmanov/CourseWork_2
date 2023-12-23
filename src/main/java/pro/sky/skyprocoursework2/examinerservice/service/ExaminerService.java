package pro.sky.skyprocoursework2.examinerservice.service;

import pro.sky.skyprocoursework2.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestion(int amount);
}
