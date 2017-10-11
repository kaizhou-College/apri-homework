package entity;


import java.util.Date;

public class Myuser {
	private int Id;
	private String Name;
	private String Password;
	
	public Myuser() {
		super();
	
	}

	public Myuser(int id, String name, String password) {
		super();
		Id = id;
		Name = name;
		Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

	public String toString() {
		
		return super.toString();
	}
	
    
}
