package com.wtg.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.wtg.entity.Child;
/**
 * //���л��������״̬��Ϣת��Ϊ���Դ洢�������ʽ�Ĺ���
//�����л������Դ洢�������ʽ��������תΪ�����״̬��Ϣ
//ǰ���ǣ�Ҫд���ļ��������ʵ��Serializable�ӿ�
 * @author WTG
 *
 */
public class Test5 {
	public static void main(String[] args) throws Exception {
		/*//���л�
		//1.���뵽child����ı��ĵ���
		 OutputStream out=new FileOutputStream("child.txt");
		 //2.���ı��ĵ���װ�������������
		 ObjectOutputStream  oos=new ObjectOutputStream(out);
		 //3.new ������
		 Child ch=new Child();
		 //4.��������ֵ
		 ch.setAge(3);
		 ch.setName("ԪԪ");
		 //5.�����ֵ�Ķ���д���װ����
		 oos.writeObject(ch);
		 //6.����
		 oos.close();
		 out.close();
		 */
		
		//�����л�
		 //����
		InputStream is = new FileInputStream("child.txt");
		//�����װ����
		ObjectInputStream ois = new ObjectInputStream(is);
		//������������
		Child chi = (Child) ois.readObject();
		System.out.println(chi);
		
		ois.close();
		is.close();
	}
}
