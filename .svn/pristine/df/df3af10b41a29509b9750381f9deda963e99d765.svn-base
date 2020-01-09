package com.rj.bd.login;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class LoginServiceImpl implements ILoginService {
	
Dao dao = new DaoImpl();
	
	@Override
	public Map<String, Object> queryForMessage(String user_mail, String user_pwd)
			throws ClassNotFoundException, SQLException {
		String sql = "select * from LoginMessage where user_mail=? and user_pwd=?";
		int[] types = new int[2];
		types[0] = Types.VARCHAR;
		types[1] = Types.VARCHAR;
		Object[] values = new Object[2];
		values[0] = user_mail;
		values[1] = user_pwd;
		return dao.executeQueryForMap(sql, types, values);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc   修改密码
	 */
	@Override
	public void UpdatePwd(String user_mail,String user_pwd) throws ClassNotFoundException, SQLException {
			dao.executeUpdate("update loginmessage set user_pwd = '"+user_pwd+"' where user_mail='" + user_mail + "'" );
	}
	

}
