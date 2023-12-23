package pro.sky.skyprocoursework2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;
import pro.sky.skyprocoursework2.examinerservice.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
    @GetMapping("/exam/get/{amount}")
    public Collection <Question> getAllAmount (@PathVariable("amount")int amount){
        return service.getQuestion(amount);
    }

}
