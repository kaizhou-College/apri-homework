package com.kz.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Utils {
    public static String EncoderByMd5(String pwd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //ȷ�����㷽�� 
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //���ܺ���ַ���
        String newstr=base64en.encode(md5.digest(pwd.getBytes("utf-8")));
        return newstr;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	//���������ժҪ��Ϣ
		System.out.println(new MD5Utils().EncoderByMd5("admin"));
	}
}
