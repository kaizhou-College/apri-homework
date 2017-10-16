package com.kz.Utils.Function;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Date extends SimpleTagSupport{
	private String value;
	private String pattern;
	@Override
	public void doTag() throws JspException, IOException {
		java.util.Date st = null;
		String Nowdate =null;
		JspWriter out = getJspContext().getOut();
			try {
				st = new SimpleDateFormat("yyyy-MM-dd").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Nowdate = new SimpleDateFormat(pattern).format(st);
			System.out.println(Nowdate);
			out.print(Nowdate);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
