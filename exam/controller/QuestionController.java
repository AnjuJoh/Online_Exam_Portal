package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@Autowired
	private QuizService quizService;

//	add question
	@PostMapping("/")
	public ResponseEntity<Questions> add(@RequestBody Questions question) {
		return ResponseEntity.ok(this.service.addQuestion(question));
	}

//	update question
	@PutMapping("/")
	public ResponseEntity<Questions> update(@RequestBody Questions question) {
		return ResponseEntity.ok(this.service.updateQuestion(question));
	}

//	get all question of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Questions> questions = quiz.getQuestions();

		return ResponseEntity.ok(questions);
	}

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizExaminer(@PathVariable("qid") Long qid) {
		Quiz quiz = new Quiz();
		quiz.setQid(qid);
		Set<Questions> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);

	}

//	get single question
	@GetMapping("/{quesId}")
	public Questions get(@PathVariable("quesId") Long quesId) {
		return this.service.getQuestion(quesId);
	}

//	delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		this.service.deleteQuestion(quesId);
	}
//
//	evaluate quiz
//	@PostMapping("/eval-quiz")
//	public ResponseEntity<?> evalQuiz(@RequestBody List<Questions> questions){
//		System.out.println(questions);
//		 double marksGot = 0;
//		 int correctAnswers = 0;
//		 int attempted = 0;
//		 for (Questions q : questions){
//			Questions question=this.service.get(q.getQuesId());
//			if(question.getAnswer().equals(q.getGivenAnswers()));
//			{
//				correctAnswers++;
//				
//				double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
//				marksGot += marksSingle;
//				
//			}
//			if(q.getGivenAnswers()!=null) {
//				attempted++;
//			}
//		};
//		
//		Map<String , Object> map =Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
//		return ResponseEntity.ok(map);
//	}

}
