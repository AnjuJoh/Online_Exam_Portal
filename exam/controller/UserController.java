package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exam.model.User;
import com.exam.model.exam.Quiz;
import com.exam.service.impl.UserServiceImpl;
import com.razorpay.*;


@RestController
@CrossOrigin("*")
public class UserController {
	

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/test")
	public String test() {
		return "Welcome to backend api of Exam portal";
	}
	
	
	@PostMapping("/api/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {
		return userServiceImpl.registerUser(user);
	}
	
	@GetMapping("/api/getUsers")
	public ResponseEntity<List<User>> getAllUsers() throws Exception {
		return ResponseEntity.ok(this.userServiceImpl.getUsers());
		
	}
	
	@GetMapping("/api/getUser/{id}")
	public User getUser(@PathVariable("id") Long id) throws Exception {
		return this.userServiceImpl.getUser(id);
	}
//	
	@PutMapping("/api/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) throws Exception{
		return ResponseEntity.ok(this.userServiceImpl.updateUser(user));
	}
	
	
	@PostMapping("/api/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data) throws Exception {
//		System.out.println("Hey order function ex.");
		System.out.println(data);
       
		int amt=Integer.parseInt((String) data.get(data.get("payment").toString()));
		var client= new RazorpayClient("rzp_test_J92LIKRd7fHLDn", "39yJLvO09hB843DApH5ZxuQ0");
		
		JSONObject ob=new JSONObject();
		ob.put("amount", amt*100);
		ob.put("currency", "INR");
		ob.put("receipt","txn_123456");
		
		Order order=client.Orders.create(ob);
		System.out.println(order);
		return "done";
	}
//	 @RequestMapping( method = RequestMethod.GET)
//	    @ResponseBody
//	    public String hello_world() {
//	        RestTemplate restTemplate = new RestTemplate();
//	        String url = "http://localhost:5000";
//	        String response = restTemplate.getForObject(url, String.class);
//	        return response;
//	    }
//	 @RequestMapping( method = RequestMethod.GET)
//	    @ResponseBody
//	    public String  eye_on_mask() {
//	        RestTemplate restTemplate = new RestTemplate();
//	        String url = "http://localhost:5000";
//	        String response = restTemplate.getForObject(url, String.class);
//	        return response;
//	    }
//	 @RequestMapping( method = RequestMethod.GET)
//	    @ResponseBody
//	    public String  find_eyeball_position() {
//	        RestTemplate restTemplate = new RestTemplate();
//	        String url = "http://localhost:5000";
//	        String response = restTemplate.getForObject(url, String.class);
//	        return response;
//	    }
//	 @RequestMapping( method = RequestMethod.GET)
//	    @ResponseBody
//	    public String   contouring() {
//	        RestTemplate restTemplate = new RestTemplate();
//	        String url = "http://localhost:5000";
//	        String response = restTemplate.getForObject(url, String.class);
//	        return response;
//	    }

//	get quiz
//	@GetMapping("/")
//	public ResponseEntity<?> quizzes(){
//		return ResponseEntity.ok(this.quizService.getQuizzes());
//	}
}
