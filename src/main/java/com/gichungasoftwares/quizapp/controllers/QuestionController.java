package com.gichungasoftwares.quizapp.controllers;

import com.gichungasoftwares.quizapp.models.Question;
import com.gichungasoftwares.quizapp.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionsService questionsService;

    // get all questions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionsService.getAllQuestions();
    }

//    get a list of questions by category
    @GetMapping("category/{category}")
    public List<Question> getAllQuestions(@PathVariable String category){
        return questionsService.findQuestionsByCategory(category);
    }

//    add a question to the database
    @PostMapping("add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
//         Question newQuestion = question;
         return questionsService.addQuestion(question);
    }

//    update a question in the database
    @PutMapping("update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question updatedQuestion = question;
        return questionsService.updateQuestion(updatedQuestion);
    }

//

}
