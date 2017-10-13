package com.wtg.entity;
/**
 * 
 * @author WTG
 *这个类要想被克隆，必须实现cloneable接口
 */
public class Book {//implements Cloneable{
	private int id;                                
	private String name;                         
	private int price;                                 
	private String writer;
	private StudentInfo stu;
	public StudentInfo getStu() {
		return stu;
	}
	public void setStu(StudentInfo stu) {
		this.stu = stu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/*@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", writer=" + writer + "]";
	}
	*/
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", stu=" + stu + ", writer=" + writer + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Book book=(Book) super.clone();
		StudentInfo stu1 = (StudentInfo) this.stu.clone();
		book.setStu(stu1);
		return book;
	}
}
