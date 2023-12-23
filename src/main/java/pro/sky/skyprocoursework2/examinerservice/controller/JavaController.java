package pro.sky.skyprocoursework2.examinerservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;
import pro.sky.skyprocoursework2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion(
            @RequestParam String question,
            @RequestParam String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/get")
    public Collection<Question>getQuestions(){
        return questionService.getAll();

    }
    @GetMapping("/remove")
    public Question removeQuestions(
            @RequestParam String question,
            @RequestParam String answer){
        Question question3 = new Question(question, answer);
        return questionService.remove(question3);
    }
    @GetMapping("/find")
    public Question findQuestions(
            @RequestParam String question){;
        return questionService.find(question);
    }

    @GetMapping("/find1")
    public String findAnswer(
            @RequestParam String question){;
        return questionService.findQuestion(question);
    }
}

