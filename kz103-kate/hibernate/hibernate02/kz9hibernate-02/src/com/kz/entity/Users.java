package com.kz.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	//private Long uuid;
	private String uuid;
	private String uname;
	private String sex;
	private Double salary;
	private Long age;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String uname, String sex) {
		this.uname = uname;
		this.sex = sex;
	}

	/** full constructor */
	public Users(String uname, String sex, Double salary, Long age) {
		this.uname = uname;
		this.sex = sex;
		this.salary = salary;
		this.age = age;
	}

	// Property accessors

	
	public String getUname() {
		return this.uname;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}