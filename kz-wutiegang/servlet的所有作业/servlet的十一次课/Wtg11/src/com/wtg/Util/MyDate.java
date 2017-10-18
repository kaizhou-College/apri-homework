package com.wtg.Util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyDate extends SimpleTagSupport{
	private	Date value;
	private String pattern;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		JspWriter out = getJspContext().getOut();
		
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		
		sdf.format(value);
		out.print(sdf.toPattern());
	}
	public Date getValue() {
		return value;
	}
	public void setValue(Date value) {
		this.value = value;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
