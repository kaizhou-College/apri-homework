package com.kz.util;

import java.util.UUID;

public class FileNameUtils {
	public static String getUUIDName(String filename){
		//2.jpg---222222-2d-sdf-sd-f2.jpg
		String newFileName = UUID.randomUUID()+filename;
		System.out.println("newFileName="+newFileName);
		return newFileName;
	}
}
