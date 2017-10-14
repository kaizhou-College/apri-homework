import entity.Song;
import entity.TeacherInfo;



//克隆：讲对象在内存中拷贝一份
//浅度克隆：只会克隆对象的非自定义属性
//深度克隆：可以克隆对象的自定义属性
public class Test4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//浅度克隆
		TeacherInfo t = new TeacherInfo();
		t.setTeachername("薛之谦");
		
		//深度克隆
		/*Song sg = new Song();
		sg.setName("意外");
		t.setSg(sg);
		System.out.println(t.getTeachername());
		System.out.println(t.getSg());
		
		TeacherInfo t2 = (TeacherInfo) t.clone();
		t2.setTeachername("王力宏");
		//改薛之谦的歌曲名字
		Song sg2=new Song();
		sg2.setName("我们的歌");
		t2.setSg(sg2);
		System.out.println(t.getTeachername());
		System.out.println(t.getSg());*/
		

	}
}
