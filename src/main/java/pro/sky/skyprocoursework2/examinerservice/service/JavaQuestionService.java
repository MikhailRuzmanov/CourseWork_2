package pro.sky.skyprocoursework2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.examinerservice.domain.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {


    private final List<Question> questions = new ArrayList<>(List.of(
            new Question("Дважды два?", "Равно четыре"),
            new Question ("Какого цвета небо?", "Небо голубое"),
            new Question("Время обеда?","12:00")));


    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)){
            throw new IllegalArgumentException();
        }
        questions.add(question1);
        return question1;
    }


    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(questions.size());

        return questions.get(i);
    }
    @Override
    public Question find(String question){
       return questions.stream()
                .filter(e->e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);


    }

    @Override
    public String findQuestion(String question){
        return questions.stream()
                .filter(e->e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getAnswer();


    }


}
