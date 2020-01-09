package com.rj.bd.preowned;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IPreownedService {
	/**
	 * @desc  添加二手商品
	 * @param user_mail
	 * @param listName
	 * @param preowned_list_introduction
	 * @param preowned_list_type
	 * @param preowned_list_pirce
	 * @param preowned_list_percent 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	void addPreowned(String user_mail, String listName, String preowned_list_introduction,
			String preowned_list_type, String preowned_list_pirce, String preowned_list_percent) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	/**
	 * @desc  查询所有商品
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryAllMessage() throws ClassNotFoundException, SQLException;
	/**
	 * @desc 	通过商品的ID查询商品功能
	 * @param preowned_id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryMessageById(String preowned_id) throws ClassNotFoundException, SQLException;
	/**
	 * @desc  通过商品的类型查询商品功能
	 * @param preownedd_list_type
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryAllMessageByType(String preownedd_list_type) throws ClassNotFoundException, SQLException;
	/**
	 * @desc  通过商品的ID删除商品
	 * @param preowned_id
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	void deletePreownedById(String preowned_id) throws ClassNotFoundException, SQLException;
	/**
	 * @desc  通过当前登录的邮箱进行查询
	 * @param user_mail
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	List<Map<String, Object>> queryMessageByUserMail(String user_mail) throws ClassNotFoundException, SQLException;
	
}
