package entity;
/**
 * 
 * @author 
 * ��������ͱ���һ��  ������������ֶ���һ��
 * ������ܱ���¡������Ҫʵ��cloneable�ӿ�
 */
public class TeacherInfo{ //extends Object implements Cloneable{
			
	private int teacherid;                         
	private String teachername;                     
	private String teachertel;                  
	private String teachermail;
	//private Song  sg;
	

	public int getTeacherid() {
		return teacherid;
	}


	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}



	public String getTeachername() {
		return teachername;
	}


	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}


	public String getTeachertel() {
		return teachertel;
	}


	public void setTeachertel(String teachertel) {
		this.teachertel = teachertel;
	}


	public String getTeachermail() {
		return teachermail;
	}


	public void setTeachermail(String teachermail) {
		this.teachermail = teachermail;
	}


	@Override
	public String toString() {
		return "TeacherInfo [teacherid=" + teacherid + ", teachermail="
				+ teachermail + ", teachername=" + teachername
				+ ", teachertel=" + teachertel + "]";
	}

	
//	public Song getSg() {
//		return sg;
//	}
//
//
//	public void setSg(Song sg) {
//		this.sg = sg;
//	}

	

//	public String toString() {
//		return "TeacherInfo [sg=" + sg + ", teacherid=" + teacherid
//				+ ", teachermail=" + teachermail + ", teachername="
//				+ teachername + ", teachertel=" + teachertel + "]";
//	}
//
//
//	public Object clone() throws CloneNotSupportedException {
//		
//		TeacherInfo t = (TeacherInfo) super.clone();
//		
//		Song sgz = (Song) this.sg.clone(); 
//		//����¡�ĸ������Ƹ���¡��TeacherInfo
//		
//		t.setSg(sgz);
//		
//		return t;
//			
//	}
	
	
}
