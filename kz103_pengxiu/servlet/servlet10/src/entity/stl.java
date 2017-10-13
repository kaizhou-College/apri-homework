package entity;

import java.io.Serializable;

public class stl extends Object implements Cloneable,Serializable {
	public String name;
	public String Sec;
	public GirlFriend gf;
	public stl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stl(String name, String sec) {
		super();
		this.name = name;
		Sec = sec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSec() {
		return Sec;
	}
	public void setSec(String sec) {
		Sec = sec;
	}
	public GirlFriend getGf() {
		return gf;
	}
	public void setGf(GirlFriend gf) {
		this.gf = gf;
	}
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();
		
		stl u = (stl) super.clone();
		GirlFriend gf2 = (GirlFriend) this.gf.clone();
		//将克隆的女朋友复制给克隆的User
		u.setGf(gf2);
		return u;
	}
	@Override
	public String toString() {
		return "stl [Sec=" + Sec + ", name=" + name + "]";
	}
	
}
