package com.gichungasoftwares.quizapp.services;

import com.gichungasoftwares.quizapp.dbs.QuestionRepository;
import com.gichungasoftwares.quizapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionRepository questionRepository;

//    get all questions from the database
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

//    get questions by category
    public List<Question> findQuestionsByCategory(String category){
        return questionRepository.findQuestionsByCategory(category);
    }

//    add a question to the database
    public ResponseEntity<Question> addQuestion(Question newQuestion) {
        try{
            return new ResponseEntity<>(questionRepository.save(newQuestion), HttpStatus.CREATED);
        } catch (Exception e){
//            return e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepository.save(newQuestion), HttpStatus.CREATED);
    }

//    handle the logic of updating a question
    public ResponseEntity<Question> updateQuestion(Question updatedQuestion) {
        return new ResponseEntity<>(questionRepository.save(updatedQuestion), HttpStatus.OK);
    }

}
