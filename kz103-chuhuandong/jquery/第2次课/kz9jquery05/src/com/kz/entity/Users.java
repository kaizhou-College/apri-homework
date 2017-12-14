package com.kz.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {
	// Fields
	private Long id;
	private String name;
	private Long age;
	private String sex;
	private Double salary;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String name, Long age, String sex, Double salary) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Users [age=" + age + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + ", sex=" + sex + "]";
	}
	

}
