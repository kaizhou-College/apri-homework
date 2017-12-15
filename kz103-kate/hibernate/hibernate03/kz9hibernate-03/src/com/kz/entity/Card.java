package com.kz.entity;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private Long cid;
	private String cname;
	//得到卡的信息的同时 我们得到人的所有信息
	private Person person;

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** full constructor */
	public Card(Long cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	// Property accessors
	
	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "Card [cid=" + cid + ", cname=" + cname 
				+ "]";
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}