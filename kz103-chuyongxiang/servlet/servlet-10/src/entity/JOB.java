package entity;

public class JOB implements Cloneable{
	public String zhiwei;


	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	
}
