package com.rj.bd.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
	void updateUserInfo(String listName, String user_name, String user_motto, String user_mail,HttpServletRequest request) throws ClassNotFoundException, SQLException;


	Map<String, Object> queryForUserMessageByTel(String user_mail) throws ClassNotFoundException, SQLException;
	/**
	 * @dessc 保存修改信息
	 * @param user_mail
	 * @param user_name
	 * @param user_motto
	 * @param user_sex
	 * @param user_address
	 * @param user_photo
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	void saveEdit(String user_mail, String user_name, String user_motto, String user_sex, String user_address,
			String user_photo) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	/**
	 * @desc  修改背景图片
	 * @param user_mail
	 * @param user_img
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	void saveimgEdit(String user_mail, String user_img) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	

}
