package entity;

public class Constellation {
	private int id;
	private String name; 
	private String content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String toString() {
		return "constellation [content=" + content + ", id=" + id + ", name="
				+ name + "]";
	}
}
