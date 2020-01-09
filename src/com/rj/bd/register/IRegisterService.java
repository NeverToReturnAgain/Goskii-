package com.rj.bd.register;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @desc   
 * @author dell
 * @time   2019年12月21日
 */
public interface IRegisterService {


	/**
	 * @desc 判断用户是否存在,存在则不能再次添加(返回true)
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	boolean userPresenceJudgment(String user_mail) throws ClassNotFoundException, SQLException;

	/**
	 * @desc  添加用户到库
	 * @param user_mail
	 * @param user_pwd
	 * @param code
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	void addUserToDatabase(String user_mail, String user_pwd)throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;


}
