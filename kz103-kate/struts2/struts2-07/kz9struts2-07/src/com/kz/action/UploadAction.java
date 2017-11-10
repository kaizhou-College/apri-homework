package com.kz.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/*�ϴ����ļ�����: ���ֱ�����ļ����nameֵ��ͬ*/
	private File upload;
	/*�ϴ����ļ�����*/
    private String uploadContentType;
    /*�ϴ����ļ�����*/	
    private String uploadFileName;
    
    public String upload(){
    	System.out.println(upload+"========="+uploadContentType+"========"+uploadFileName);
    	
    	File destFile =new  File("d://upload//"+getNewFileName(uploadFileName));
		try {
			FileUtils.copyFile(upload, destFile );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "";
    }
    
    //jndiԭ��ͼ.png
    public String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	//System.out.println("uuid===="+uuid);
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+��׺
    	System.out.println("newName==="+newName);
    	return newName;
    }
    
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

    
    
    


}
