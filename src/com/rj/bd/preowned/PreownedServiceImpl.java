package com.rj.bd.preowned;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class PreownedServiceImpl implements IPreownedService {
Dao dao = new DaoImpl();

	/**
	 * @desc 插入商品数据
	 */
	@Override
	public void addPreowned(String user_mail, String listName, String preowned_list_introduction,
			String preowned_list_type, String preowned_list_pirce,String preowned_list_percent) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String id = UUID.randomUUID().toString().substring(0, 6);
		
		String sql = "insert into preowned values(?,?)";
		int[] types = new int[2];
		types[0] = Types.VARCHAR;
		types[1] = Types.VARCHAR;
		Object[] values = new Object[2];
		values[0]  = id;
		values[1] = user_mail;
		dao.executeUpdate(sql, types, values);	
		
		String sql2 = "insert into preowned_list values(?,?,?,?,?,?,?)";
		int[] types2 = new int[7];
		types2[0] = Types.VARCHAR;
		types2[1] = Types.VARCHAR;
		types2[2] = Types.VARCHAR;
		types2[3] = Types.VARCHAR;
		types2[4] = Types.VARCHAR;
		types2[5] = Types.VARCHAR;
		types2[6] = Types.VARCHAR;
		Object[] values2 = new Object[7];
		values2[0] = id;
		values2[1] = listName;
		values2[2] = preowned_list_type;
		values2[3] = preowned_list_introduction;
		values2[4] = preowned_list_pirce;
		values2[5] = preowned_list_percent;
		values2[6] = user_mail;
		dao.executeUpdate(sql2, types2, values2);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  查询所有信息+发布商品的用户信息
	 */
	@Override
	public List<Map<String, Object>> queryAllMessage() throws ClassNotFoundException, SQLException {
			String sql = " SELECT u.user_name,u.user_photo,p.* FROM  usermessage u RIGHT JOIN preowned_list p  ON u.user_mail=p.user_mail ";
//			String sql2 = "select u.* from usermessage u";
//			dao.executeQueryForList(sql2);
			return dao.executeQueryForList(sql);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  通过ID查询详细信息
	 */
	@Override
	public List<Map<String, Object>> queryMessageById(String preowned_id) throws ClassNotFoundException, SQLException {
		
		
		String sql = "select * from preowned_list where preowned_id=?";
		int[] types = new int[1];
		types[0] = Types.VARCHAR;
		Object[] values = new Object[1];
		values[0] = preowned_id;
		return dao.executeQueryForList(sql, types, values);
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  通过商品的类型查询详细信息
	 */
	@Override
	public List<Map<String, Object>> queryAllMessageByType(String preownedd_list_type) throws ClassNotFoundException, SQLException {

		String sql = "select * from preowned_list where preownedd_list_type=?";
		int[] types = new int[1];
		types[0] = Types.VARCHAR;
		Object[] values = new Object[1];
		values[0] = preownedd_list_type;
		return dao.executeQueryForList(sql, types, values);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 通过商品ID删除商品
	 */
	@Override
	public void deletePreownedById(String preowned_id) throws ClassNotFoundException, SQLException {
			dao.executeUpdate("delete from preowned_list where preowned_id = '"+preowned_id+"' ");
			dao.executeUpdate("delete from preowned where preowned_id = '"+preowned_id+"'");
			
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  通过当前登录的邮箱进行查询
	 */
	@Override
	public List<Map<String, Object>> queryMessageByUserMail(String user_mail) throws ClassNotFoundException, SQLException {
			return dao.executeQueryForList(" SELECT u.user_name,u.user_photo,p.* FROM  usermessage u  JOIN preowned_list p   WHERE user_mail= '"+user_mail+"'");
	}


}
