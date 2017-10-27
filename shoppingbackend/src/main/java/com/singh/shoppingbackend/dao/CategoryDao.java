package com.singh.shoppingbackend.dao;

import java.util.List;

import com.singh.shoppingbackend.dto.Category;

public interface CategoryDao {

	//boolean addCategory(Category category) ;
	
	List <Category> list();
	
	Category getCategory(int id);
}
