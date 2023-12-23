package com.gichungasoftwares.quizapp.dbs;

import com.gichungasoftwares.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionsByCategory(String category);
}
