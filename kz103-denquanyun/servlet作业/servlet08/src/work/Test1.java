package work;
/*
4.��d: дһ��Test1�࣬��main�����е�����e�̵�Test2���һ��������
Ȼ���ڸ�java�������ڵ��̷��±�������Ժ�
��c��ʹ��java ��������:java Test.java
ǰ���ڻ�������������  classpath=".;d:\;e:\"

 * */
public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class clazz = loader.loadClass("Test2");
		
	}
	
}
