package pro.sky.skyprocoursework2.examinerservice.service;

import pro.sky.skyprocoursework2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add (String question, String answer);
    //Question add (Question question);
    Question remove (Question question);
    Collection<Question>getAll();
    Question getRandomQuestion();
    Question find(String question);
    String findQuestion(String question);
}
