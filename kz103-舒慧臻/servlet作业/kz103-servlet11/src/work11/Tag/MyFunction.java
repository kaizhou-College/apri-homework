package work11.Tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyFunction {
/*1����ȡ���Ϻ�����ĳ���  ��һ�����Ϸ��ؼ��ϵĳ���
	${kz:size(lists)}  �����Ǽ���*/
	public static int getListLength(List list){
		int num = list.size();
		return num;
	}
	/*2����ʽ������-string   ��һ���ַ����ڷ���ָ����ʽ���ַ�����
	${kz:dateFormat("2015-10-12",'yyyy��MM��dd��')}
	*/
	public static String dateToString(String date,String str){
		Date st = null;
		String Nowdate =null;
		try {
			st = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Nowdate = new SimpleDateFormat(str).format(st);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Nowdate;
	}

	/*4��indexOf����  ��һ���ַ�����ָ���ַ���±�
	${kz:indexOf("1#22#22#33",'2')}
	���Ϊ��2*/
	public static int indexOf(String str,String str1){
		int num = str.indexOf(str1);
		return num;
	}
}
