package entity;

public class Song implements Cloneable{
	
		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
		public Object clone() throws CloneNotSupportedException {
		
			return super.clone();
		}

}
