package com.kz.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.kz.utils.DownloadUtils;

public class DownloadAction {
	private String filename;

	public String download() {
		System.out.println("old filename====" + filename);
		return "success";
	}

	public InputStream getInputStream() throws UnsupportedEncodingException {
		try {
			String newFilename = new String(filename.getBytes("iso-8859-1"),"utf-8");
			return new FileInputStream("d://upload//" + newFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getContentType() {
		String type = ServletActionContext.getServletContext().getMimeType(
				filename);
		System.out.println("type="+type);
		return type;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
