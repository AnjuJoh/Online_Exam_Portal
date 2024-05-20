package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;
import com.exam.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	List<Category> findAllByUser(User user);

}
