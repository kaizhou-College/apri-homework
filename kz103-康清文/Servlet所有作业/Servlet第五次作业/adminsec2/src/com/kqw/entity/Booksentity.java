package com.kqw.entity;

public class Booksentity {
		
		private int id;
		private String name;
		
		
		public  Booksentity(){
			
			
		}

		public Booksentity(int id, String name) {
			super();
			this.id = id;
			this.name = name;
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




		public String toString() {
			return "Books [id=" + id + ", name=" + name + "]";
		}
		
		
		
	
}
