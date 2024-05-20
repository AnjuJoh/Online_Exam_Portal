package com.exam.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;

public interface QuestionService {
	
	public Questions addQuestion(Questions question);
	
	public Questions updateQuestion(Questions question);
	
	public Set<Questions> getQuestions();
	
	public Questions getQuestion (Long questionId);
	
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);
	
	public Questions get(Long questionsId);


}
