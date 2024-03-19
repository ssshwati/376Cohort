package com.wileyedge;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private String name;
	private PageContext pageContext = null;
	
	public HelloTag(){
		System.out.println("inside constructor");
	}
	
	public void setName(String name) {
		System.out.println("inside setName of hello tag");
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("inside doTag() of hello tag");
		pageContext = (PageContext)getJspContext();
		JspWriter out = pageContext.getOut();
		out.print("welcome "+name);
	}
	
}
