package com.wileyedge.firstbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView sayHello() {
		System.out.println("inside say hello of controller");
		System.out.println("invoking business layer");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("msg","welcome to spring mvc using boot");
		
		return mav;
	}
}
