package com.kz.entity;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Long pid;
	private String pname;
	//的到人的信息的同时 得到卡的所有信息
	
	private Card card;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(String pname) {
		this.pname = pname;
	}
	

	// Property accessors

	@Override
	public String toString() {
		return "Person [, pid=" + pid + ", pname=" + pname
				+ "]";
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}