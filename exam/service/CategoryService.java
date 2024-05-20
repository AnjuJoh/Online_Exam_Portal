package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.model.User;
import com.exam.model.exam.Category;

public interface CategoryService {
	
	public Category addcategory(Category category);
	
	public Category updatecategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoryId);
	
	public void deleteCategory(Long categoryId);

	public List<Category> getCategoriesByUser(User user);

}
