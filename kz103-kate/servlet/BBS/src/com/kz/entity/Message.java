package com.kz.entity;

import java.util.Date;

public class Message {
	private int messageid ;                              
	private String title;                
	private String contents;               
	private String writer;          
	private Date writedate;                                 
	private int count;
	
	
	@Override
	public String toString() {
		return "Message [contents=" + contents + ", count=" + count
				+ ", messageid=" + messageid + ", title=" + title
				+ ", writedate=" + writedate + ", writer=" + writer + "]";
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
