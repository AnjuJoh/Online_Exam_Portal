package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.exam.model.exam.QuizHistory;

@Repository
public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long>{
	
  public QuizHistory findByUserIdAndQuizId(int userId,int quizId);

}
