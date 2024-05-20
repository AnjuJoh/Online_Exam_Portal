package com.exam.model.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuizHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int numberOfAttempts;
	private int previousScore;
	private int userId;
	private int quizId;
	

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public int getPreviousScore() {
		return previousScore;
	}

	public void setPreviousScore(int previousScore) {
		this.previousScore = previousScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	

}
