package com.kz.test;
//Ϊʲô��java���������Ҫ3�����������
public class Test4 {
	public static void main(String[] args) throws ClassNotFoundException {
		//1, ϵͳ��������sun.misc.Launcher$AppClassLoader@1372a1a
		//ϵͳ�������Ǽ��أ������е�classes�ļ����µ�clas���ļ�
		//���������û�м��ص��ͻᵽ jdk��classpath��·����ȥ����
		Class c1 = Class.forName("com.kz.entity.Man");
		ClassLoader cl1 = c1.getClassLoader();
		System.out.println(cl1);
		
		//2,��չ��������JDK_HOME/jre/lib/ext�¼���class
		//Class ext = Class.forName("sun.security.mscapi.Key");
		//Class ext = Class.forName("com.kz.entity.Pig");
		//System.out.println(ext.getClassLoader());
		
		//3,��������: jdk���İ� lib�µİ� rt.jar tool.jar
		//Class root = Class.forName("java.lang.Object");
		//System.out.println(root.getClassLoader());
	
		//����ԭ��
		//1,ί�м��ػ���
		//����������յ�����������ʱ�����ȵ���app�����������ǲ������ϼ���
		//app���������Ҫί��ext���������أ�ext�������Ҳ�����ȼ��أ���ί�и�������
		//����,��������������ز������ŵ�ext���������أ�ext���������ز����ٵ�app������
		//���أ�app�������ͻᱨ��ClassNotFoundException�쳣
		//2,һ����ԭ��
		//ֻҪ��һ�����������ص����࣬��ô�������ؾͲ����ټ����ˣ�
		//��֤���ص����һ����
		
		//3,͸����ԭ��
		//�ײ�����������Կ���������������ص����ݡ�
		//���ǵĳ�����ʹ��java�ĺ���api(Object)
		
		
		
	
	}
}
