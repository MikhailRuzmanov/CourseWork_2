package pro.sky.skyprocoursework2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceIml implements ExaminerService{


    private final QuestionService questionService;

    public ExaminerServiceIml(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount>questionService.size()){
            throw new IllegalArgumentException("Всего максимум вопросов = " + questionService.size());
        }
        Set<Question> setQuestions=new HashSet<>();
        while (setQuestions.size()<amount){
            setQuestions.add(questionService.getRandomQuestion());
        }
        return setQuestions;
    }
}
