package com.exam.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.service.QuestionService;

@Service
public class QuestionsServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Questions addQuestion(Questions question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Questions updateQuestion(Questions question) {
		return this.questionRepository.save(question);
	}
   


	@Override
	public Set<Questions> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Questions getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
	Questions question=new Questions();
	question.setQuesId(quesId);
	this.questionRepository.delete(question);
		
	}

	@Override
	public Questions get(Long questionsId) {
		
		return this.questionRepository.getOne(questionsId);
	}
}
