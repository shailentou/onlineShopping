package com.singh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.singh.shoppingbackend.dao.CategoryDao;
import com.singh.shoppingbackend.dto.Category;
/*
import com.singh.shoppingbackend.dao.CategoryDao;
import com.singh.shoppingbackend.dto.Category;
*/
@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDAO;
 
	
@RequestMapping(value= { "/home", "/homepage"})
	public ModelAndView Index()
	{
		ModelAndView mv= new ModelAndView("homepage");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv; 
	}


	@RequestMapping(value= "show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv= new ModelAndView("homepage");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickShowAllProducts", true);
		
		return mv;
	}
	
	@RequestMapping(value= "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable ("id") int id)
	{
		ModelAndView mv= new ModelAndView("homepage");
		Category category=categoryDAO.getCategory(id);
		
		
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickShowCategoryProducts", true);
		
		return mv;
	}
	



@RequestMapping(value= "/about")
public ModelAndView about()
{
	ModelAndView mv= new ModelAndView("homepage");
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", true);
	
	return mv;
}

@RequestMapping(value= "/contact")
public ModelAndView contact()
{
	ModelAndView mv= new ModelAndView("homepage");
	mv.addObject("title", "Contact Us");
	mv.addObject("userClickContact", true);
	
	return mv;
}


@RequestMapping(value= "/test/{greeting}")
public ModelAndView test(@PathVariable("greeting") String greeting )
{
	ModelAndView mv= new ModelAndView("homepage");
	mv.addObject("greeting", "Welcome to spring mvc "+ greeting);
	return mv;
}
}
