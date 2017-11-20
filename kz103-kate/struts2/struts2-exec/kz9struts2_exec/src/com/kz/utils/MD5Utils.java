package com.kz.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Utils {
    public static String EncoderByMd5(String pwd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法 
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(pwd.getBytes("utf-8")));
        return newstr;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	//生成密码的摘要信息
		System.out.println(new MD5Utils().EncoderByMd5("admin"));
	}
}
