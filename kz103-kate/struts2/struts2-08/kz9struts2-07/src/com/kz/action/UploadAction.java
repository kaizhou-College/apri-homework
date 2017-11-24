package com.kz.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/*上传的文件对象: 名字必须和文件域的name值相同*/
	private List<File> upload;
	/*上传的文件类型*/
    private List<String> uploadContentType;
    /*上传的文件命名*/	
    private List<String> uploadFileName;
    
    public String upload() throws IOException {
    	System.out.println(upload+"========="+uploadContentType+"========"+uploadFileName);
		
		for(int i=0;i<upload.size();i++){
			File destFile =new  File("d://upload//"+getNewFileName(uploadFileName.get(i)));
			FileUtils.copyFile(upload.get(i), destFile);
		}
    	return "upload_success";
    }
    
    //jndi原理图.png
    public String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	//System.out.println("uuid===="+uuid);
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+后缀
    	System.out.println("newName==="+newName);
    	return newName;
    }

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
