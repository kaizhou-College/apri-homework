package com.kz.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/*�ϴ����ļ�����: ���ֱ�����ļ����nameֵ��ͬ*/
	private List<File> upload;
	/*�ϴ����ļ�����*/
    private List<String> uploadContentType;
    /*�ϴ����ļ�����*/	
    private List<String> uploadFileName;
    
    public String upload() throws IOException {
    	System.out.println(upload+"========="+uploadContentType+"========"+uploadFileName);
		
		for(int i=0;i<upload.size();i++){
			File destFile =new  File("d://upload//"+getNewFileName(uploadFileName.get(i)));
			FileUtils.copyFile(upload.get(i), destFile);
		}
    	return "upload_success";
    }
    
    //jndiԭ��ͼ.png
    public String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	//System.out.println("uuid===="+uuid);
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+��׺
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
