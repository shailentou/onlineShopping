package com.singh.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.singh.shoppingbackend.dao.CategoryDao;
import com.singh.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao {

	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	
	private static List<Category> categoryList= new ArrayList<>();
	
	static{
		Category category = new Category();
		category.setId(1);
		category.setName("LED");
		category.setImageURL("IMG_Cat1.Png");
		category.setDescription("This is LED ");
		
		categoryList.add(category);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("MOBILE");
		category2.setImageURL("IMG_Cat2.Png");
		category2.setDescription("This is MOBILE ");
		
		categoryList.add(category2);
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("LAPTOP");
		category3.setImageURL("IMG_Cat3.Png");
		category3.setDescription("This is LAPTOP ");
		
		categoryList.add(category3);
		
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryList;
	}

	
	public Category getCategory(int id){
		
		for(Category category : categoryList)
		{			
			if (category.getId()==id)
				return category;
			}
		return null;
		
	}


/*	@Override
	@Transactional
	public boolean addCategory(Category category) {
		
		try{
			 category = new Category();
			category.setId(1);
			category.setName("LED");
			category.setImageURL("IMG_Cat1.Png");
			category.setDescription("This is LED ");
			sessionFactory.getCurrentSession().persist(category);
		}
		catch(Exception ex)
		{
	ex.printStackTrace();		
		}
		// TODO Auto-generated method stub
		return false;
	}*/
}
