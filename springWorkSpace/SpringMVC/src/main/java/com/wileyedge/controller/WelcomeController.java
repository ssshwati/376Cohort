package com.wileyedge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Inside controller");	
		System.out.println("Going to invoke business layer");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("msg","Welcome to spring mvc");
		return mav;
	}

}
