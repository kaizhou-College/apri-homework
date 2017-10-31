package com.kz.action;

import com.opensymphony.xwork2.Action;

public class TestAction implements Action{
	@Override
	public String execute() throws Exception {
		System.out.println("heihiehi");
		return "CC";
	}
}
