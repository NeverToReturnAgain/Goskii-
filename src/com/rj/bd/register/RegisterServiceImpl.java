package com.rj.bd.register;
/**
 * @desc   用户注册的M层
 * @author dell
 * @time   2019年12月21日
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.UUID;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;
import com.rj.bd.utils.CodeUtils;

public class RegisterServiceImpl implements IRegisterService {

	Dao dao = new DaoImpl();
	/**
	 * @desc  添加用户到库
	 * @param user_mail
	 * @param user_pwd
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void addUserToDatabase(String user_mail, String user_pwd) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		
		String sql1 = "insert into LoginMessage values(?,?)";
		
		dao.executeUpdate(sql1, new int[]{Types.VARCHAR,Types.VARCHAR}, new Object[]{user_mail,user_pwd});
		
		String sql2 = "insert into UserMessage values(?,?,?,?,?,?,?)";
		int[] types = new int[7];
		Object[] values = {
				user_mail,
				"用户_" + UUID.randomUUID().toString().substring(0,6),
				"",
				"",
				"0",//0代表默认性别为男
				"default_photo.jpg",
				"default_img.jpg"
				
		};
		for (int i = 0; i < 7; i++) {
			types[i] = Types.VARCHAR;
		}
		
		
		dao.executeUpdate(sql2, types, values);
		
	}
	/**
	 * @desc 判断用户是否存在,存在则不能再次添加(返回true)
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public boolean userPresenceJudgment(String user_mail) throws ClassNotFoundException, SQLException {
		String sql = "select * from LoginMessage where user_mail='" + user_mail + "'";
		Map<String, Object> map = dao.executeQueryForMap(sql);
		
		if(map!=null) return true;
		return false;
	}

	
	

}
