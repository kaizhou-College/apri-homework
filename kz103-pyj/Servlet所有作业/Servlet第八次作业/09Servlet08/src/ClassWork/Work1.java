package ClassWork;

import entity.HashMap;

public class Work1 {
	public static void main(String[] args) {
		try {
			//��ʽһ
			Class clazz=Class.forName("entity.HashMap");
			HashMap ha=(HashMap)clazz.newInstance();
			ha.HashMap();
			//������
			Class cl=HashMap.class;
			HashMap ha2=(HashMap) cl.newInstance();
			ha2.HashMap();
			//������
			HashMap hm=new HashMap();
			Class cla=hm.getClass();
			HashMap hm2=(HashMap)cla.newInstance();
			hm2.HashMap();
			//��ʽ��
			ClassLoader cls=ClassLoader.getSystemClassLoader();
			Class clas=cls.loadClass("entity.HashMap");
			HashMap hm3=(HashMap)clas.newInstance();
			hm3.HashMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
