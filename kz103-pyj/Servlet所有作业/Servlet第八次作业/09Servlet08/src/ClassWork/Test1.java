package ClassWork;
/*��d: дһ��Test1�࣬��main�����е�����e�̵�Test2���һ��������
Ȼ���ڸ�java�������ڵ��̷��±�������Ժ�
��c��ʹ��java ��������:java Test.java
ǰ���ڻ�������������  classpath=".;d:\;e:\"*/
public class Test1 {
	public static void main(String[] args) {
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		try {
			Class clazz=cl.loadClass("Test2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
