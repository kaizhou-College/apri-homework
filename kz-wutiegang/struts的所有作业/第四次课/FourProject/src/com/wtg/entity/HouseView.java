package com.wtg.entity;
//����һ���ű���û�еı�����һ���࣬�ŵ��Ǹ����оͼ̳��Ǹ���
public class HouseView extends House{
	//�������ķ���ֵ
	private String ds;
	//���ͱ�����Ķ���,������jsp����ʾ��������
	private String type;

	public String getDs() {
		return ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "HouseView [ds=" + ds + ", type=" + type + "]"+super.toString();
	}
	
	
}
