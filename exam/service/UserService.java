package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.model.User;
import com.exam.model.exam.Quiz;

public interface UserService {
		
		public User registerUser(User user) throws Exception;

		public List<User> getUsers();
		
		public User updateUser(User user) throws Exception;
//		
//		public Set<Quiz> getQuizzes();
//		
		public User getUser(Long id) throws Exception;
//		
//		public void deleteQuiz(Long quizId);

		
}
