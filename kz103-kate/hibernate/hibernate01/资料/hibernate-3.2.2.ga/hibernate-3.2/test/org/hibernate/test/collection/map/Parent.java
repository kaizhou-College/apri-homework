package org.hibernate.test.collection.map;

import java.util.Map;
import java.util.HashMap;

/**
 * todo: describe Parent
 *
 * @author Steve Ebersole
 */
public class Parent {
	private String name;
	private Map children = new HashMap();

	public Parent() {
	}

	public Parent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map getChildren() {
		return children;
	}

	public void setChildren(Map children) {
		this.children = children;
	}
}
