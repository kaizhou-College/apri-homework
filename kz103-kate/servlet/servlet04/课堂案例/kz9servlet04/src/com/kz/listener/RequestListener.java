package com.kz.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*����request����ļ�����(����)
 * request�����������ڣ���ÿ�ν��������ʱ�򴴽����������ʱ������١�һ������һ��request
 * 1�����������
 * 2������
 * 
 * */
public class RequestListener implements ServletRequestListener{
	public RequestListener(){
		System.out.println("RequestListener������");
	}
	//��request�������ٵ�ʱ�򣬾ͻ���ø÷��������������˼����¼���������Ϣ
	//web��������request�����ʱ�򣬽��¼���װ��һ��ServletRequestEvent��Ķ���
	//���ݸ�request�������ķ���
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request����������....");
		
	}
	//��request���󴴽���ʱ�򣬾ͻ���ø÷���
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request���󱻴�����....");
	}
	
}
