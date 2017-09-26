package entity;

public class book {
	private int id;
	private String name;
	private int price;
	private String writer;
	public book(int id, String name, int price, String writer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.writer = writer;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", price=" + price
				+ ", writer=" + writer + "]";
	}
	
}
