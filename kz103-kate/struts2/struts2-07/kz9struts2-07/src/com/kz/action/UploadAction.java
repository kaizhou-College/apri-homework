package com.kz.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/*上传的文件对象: 名字必须和文件域的name值相同*/
	private File upload;
	/*上传的文件类型*/
    private String uploadContentType;
    /*上传的文件命名*/	
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
    
    //jndi原理图.png
    public String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	//System.out.println("uuid===="+uuid);
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+后缀
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
