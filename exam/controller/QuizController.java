package com.exam.controller;

import java.util.List;

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

import com.exam.model.User;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.model.exam.QuizHistory;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	
	@Autowired
	private QuizService quizService;
	
//	add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
		
	}
	
//	update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
//	get quiz
	@GetMapping("/")
	public ResponseEntity<?> quizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}

//	get single quiz
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid")Long qid) {
		return this.quizService.getQuiz(qid);
	}
	
//	delete the quiz
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid")Long qid)
	{
		this.quizService.deleteQuiz(qid);                          
	}
	@PostMapping("/getQuizzes")
	public List<Quiz> getQuizzesByUser(@RequestBody User user) {
		return this.quizService.getQuizzesByUser(user);
	}
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid")Long cid)
	{
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}

	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		List<Quiz> Quizzes= this.quizService.getActiveQuizzesOfCategory(category);
		System.out.println("Quiz size"+Quizzes.size());
		return Quizzes;
	}
	@PostMapping("/quizHistory/")
	public ResponseEntity<QuizHistory> History(@RequestBody QuizHistory quizHistory){
		return ResponseEntity.ok(this.quizService.addQuizHistory(quizHistory));
		
	}
	@GetMapping("/quizHistory/{userId}/{quizId}")
	public QuizHistory getQuizHistory(@PathVariable("userId") int userId,@PathVariable("quizId") int quizId){
		
		return this.quizService.getQuizHistory(userId, quizId);
	}
}
