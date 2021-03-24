package com.devpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.devpro.entities.Category;
import com.devpro.services.CategoryService;


@Controller
public class NewsController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/news" }, method = RequestMethod.GET)
	public String hdmh(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<Category> categories = categoryService.search(null);
		model.addAttribute("categories", categories);
		return "front-end/news";
	}
	
	@RequestMapping(value = { "/newsDetail" }, method = RequestMethod.GET)
	public String newDetail(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<Category> categories = categoryService.search(null);
		model.addAttribute("categories", categories);
		return "front-end/newsDetail";
	}
	
}
