package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.model.exam.QuizHistory;
import com.exam.repo.QuizHistoryRepository;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	private QuizHistoryRepository quizHistoryRepository;
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		Quiz quiz= this.quizRepository.findById(quizId).get();
		return quiz;
	}

	@Override
	public void deleteQuiz(Long quizId) {
		
		
		this.quizRepository.deleteById(quizId);
		
	}
	@Override
	public List<Quiz> getQuizzesByUser(User user) {		
		return this.quizRepository.findAllByUser(user);
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizRepository.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		return this.quizRepository.findByCategoryAndActive(c, true);
	}

	@Override
	public QuizHistory addQuizHistory(QuizHistory quizHistory) {
		
		QuizHistory history = this.quizHistoryRepository.findByUserIdAndQuizId(quizHistory.getUserId(), quizHistory.getQuizId());
		if(history==null) {
			history = this.quizHistoryRepository.save(quizHistory);
		}else {
			history.setNumberOfAttempts(history.getNumberOfAttempts() + 1);
			history.setPreviousScore(quizHistory.getPreviousScore());
			history = this.quizHistoryRepository.save(history);
		}
		return history;
	}

	@Override
	public QuizHistory getQuizHistory(int userId, int quizId) {
		QuizHistory history = this.quizHistoryRepository.findByUserIdAndQuizId(userId, quizId);
		return history;
	}
	


}
