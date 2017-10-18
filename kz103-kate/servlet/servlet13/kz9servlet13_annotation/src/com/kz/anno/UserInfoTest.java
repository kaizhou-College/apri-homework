package com.kz.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@UserInfo("123456")
public class UserInfoTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
