package com.rj.bd.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class UserServiceImpl implements IUserService {
Dao dao = new DaoImpl();

		/**
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 * @desc  通过邮箱查询当前用户的信息
		 */
		@Override
		public Map<String, Object> queryForUserMessageByTel(String user_mail) throws ClassNotFoundException, SQLException {
			
			String sql2 = "select * from UserMessage where user_mail='"+user_mail + "'";
			return  dao.executeQueryForMap(sql2);
			
			
//			System.out.println("executeQueryForMap::"+executeQueryForMap);
//			
//			
//			System.out.println("impl中的user_mail"+user_mail);
//			String sql = "select * from UserMessage where user_mail=?";
//			int[] types = new int[1];
//			types[0] = Types.VARCHAR;
//			Object[] values = new Object[1];
//			values[0] = user_mail;
//			return dao.executeQueryForMap(sql, types, values);
			
		}
/**
 * @throws IOException 
 * @throws SQLException 
 * @throws FileNotFoundException 
 * @throws ClassNotFoundException 
 * @desc  保存个人资料修改信息
 */
		@Override
		public void saveEdit(String user_mail, String user_name, String user_motto, String user_sex, String user_address,
				String fileSaveName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
			String sql = "update UserMessage set user_name=?,user_motto=?,user_sex=? ,user_address=?,user_photo=? where user_mail=?";
			int[] types = new int[6];
			types[0] = Types.VARCHAR;
			types[1] = Types.VARCHAR;
			types[2] = Types.VARCHAR;
			types[3] = Types.VARCHAR;
			types[4] = Types.VARCHAR;
			types[5] = Types.VARCHAR;
			
			Object[] values = new Object[6];
			values[0] = user_name;
			values[1] = user_motto;
			values[2] = user_sex;
			values[3] = user_address;
			values[4] = fileSaveName;
			values[5] = user_mail;
			
			dao.executeUpdate(sql, types, values);
			
			
			
		}
		
		
		/**
		 * @throws IOException 
		 * @throws SQLException 
		 * @throws FileNotFoundException 
		 * @throws ClassNotFoundException 
		 * @desc  保存背景图片的修改信息
		 */
		@Override
		public void saveimgEdit(String user_mail, String fileSaveName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
				String sql = "update user_img set user_img=? where user_mail = ?";
				int[] types = new int[2];
				types[0] = Types.VARCHAR;
				types[1] = Types.VARCHAR;
				Object[] values = new Object[2];
				values[0] = fileSaveName;
				values[1] = user_mail;
				dao.executeUpdate(sql, types, values);
		}
		/**
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 * @desc  修改用户信息
		 */
		@Override
		public void updateUserInfo(String listName, String user_name, String user_motto,String user_mail, HttpServletRequest request) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			dao.executeUpdate("update usermessage set user_name='" + user_name + "', user_photo='"+listName+"',user_motto='"+user_motto+"' where user_mail='"+user_mail+"'" );
			
			
		}
	

}
