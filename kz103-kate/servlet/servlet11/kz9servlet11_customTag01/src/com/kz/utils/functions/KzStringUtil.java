package com.kz.utils.functions;

public class KzStringUtil {
	/**
	 * ÓÃÓÚ×Ö·û´®µÄ·Ç¿ÕÅĞ¶Ï
	 */
	public static boolean strIsNotNull(String str){
		if(str!=null&&str.trim().length()>0){
			return true;
		}
		return false;
	}
}
