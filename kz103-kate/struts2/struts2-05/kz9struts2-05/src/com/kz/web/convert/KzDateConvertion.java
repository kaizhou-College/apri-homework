package com.kz.web.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class KzDateConvertion extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] value, Class arg2) {
		String sDate = value[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		try {
			return sdf.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();//主动抛一个异常
		}
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
