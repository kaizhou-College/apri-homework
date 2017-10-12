package ClassWork;

import entity.HashMap;

public class Work1 {
	public static void main(String[] args) {
		try {
			//方式一
			Class clazz=Class.forName("entity.HashMap");
			HashMap ha=(HashMap)clazz.newInstance();
			ha.HashMap();
			//方法二
			Class cl=HashMap.class;
			HashMap ha2=(HashMap) cl.newInstance();
			ha2.HashMap();
			//方法三
			HashMap hm=new HashMap();
			Class cla=hm.getClass();
			HashMap hm2=(HashMap)cla.newInstance();
			hm2.HashMap();
			//方式四
			ClassLoader cls=ClassLoader.getSystemClassLoader();
			Class clas=cls.loadClass("entity.HashMap");
			HashMap hm3=(HashMap)clas.newInstance();
			hm3.HashMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
