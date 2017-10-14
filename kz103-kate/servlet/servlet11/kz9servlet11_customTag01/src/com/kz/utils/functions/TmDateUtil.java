package com.kz.utils.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڹ�����
 * TmDateUtil<BR>
 * ������:����ѧԺ-kate <BR>
 * ʱ�䣺2014��11��11��-����10:29:09 <BR>
 * @version 1.0.0
 *
 */
public class TmDateUtil {

	/**
	 * ����ת��
	 * ��������dateToString<BR>
	 * �����ˣ�����ѧԺ-kate <BR>
	 * ʱ�䣺2014��11��11��-����10:28:41 <BR>
	 * @param time
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static Date dateToString(String time){
		Date startTime = null;
		try {
			 startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startTime;
	}
	
	
	/**
	 * 
	 * ��������getTimeFormat<BR>
	 * �����ˣ�����ѧԺ-kate <BR>
	 * ʱ�䣺2014��11��11��-����10:28:21 <BR>
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getTimeFormat(String startTime){
		return getTimeFormat(dateToString(startTime));
	}
	
	/**
	 * ��ȡ���ڼ�����ǰ������ǰ
	 * ��������getTimeFormat<BR>
	 * �����ˣ�����ѧԺ-kate <BR>
	 * ʱ�䣺2014��11��11��-����10:27:54 <BR>
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//��
			long day_diff  = (long) Math.floor(diff/86400);//��
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],ʱ��Խ��...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"��ǰ");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 ����ǰ");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"������ǰ");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1Сʱǰ");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"Сʱǰ");
				}else if(day_diff==1){
					buffer.append("1��ǰ");
				}else if(day_diff<7){
					buffer.append(day_diff+"��ǰ");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " ����ǰ");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "��ǰ");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("����ǰ");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"��ǰ");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
}
