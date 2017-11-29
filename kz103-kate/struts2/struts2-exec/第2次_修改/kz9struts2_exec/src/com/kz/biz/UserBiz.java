package com.kz.biz;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.kz.dao.BaseDao;
import com.kz.dao.UserDao;
import com.kz.entity.QueryUser;
import com.kz.entity.User;
import com.kz.utils.MD5Utils;

public class UserBiz {
	private UserDao ud =new UserDao();
	public User findByNameAndPwd(User user) {
		//生成密码摘要信息（加密 md5）
		try {
			user.setLogonPwd(MD5Utils.EncoderByMd5(user.getLogonPwd()));
			return ud.findByNameAndPwd(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List<User> selByPage(Class<User> class1, int page, int pageSize,QueryUser qu) {
		return new BaseDao().selByPage(class1, page, pageSize,qu);
	}
	public static void main(String[] args) {
	}
	public int getMax(int pageSize,QueryUser qu) {
		return new BaseDao().getMax(User.class, pageSize,qu);
	}
	public User findById(int userID) {
		return ud.findById(userID);
	}
	public int updateUser(User user, File upload,String fileName) {
		//需要更新简历
		if(upload!=null){
			try {
				String newFileName = UUID.randomUUID().toString()+fileName;
				File destFile = new File("d://upload/"+newFileName);
				FileUtils.copyFile(upload, destFile);
				//对旧简历进行处理
				User oldUser = ud.findById(user.getUserID());
				if(oldUser.getFilename()!=null){
					//删除原来的旧简历
					File file = new File(oldUser.getPath());
					file.delete();
				}
				//设置user对象的path和filename
				user.setPath("d://upload/"+newFileName);
				user.setFilename(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ud.updateUser(user,true);
		}else{//不需要更新简历
			return ud.updateUser(user,false);
		}
	}

}
