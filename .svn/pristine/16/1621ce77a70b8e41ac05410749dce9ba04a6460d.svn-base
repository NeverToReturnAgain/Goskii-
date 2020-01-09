package com.rj.bd.discussion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class DiscussionServiceImpl implements IDiscussionService {
Dao dao = new DaoImpl();
	@Override
	/**
	 * @desc  查询所用
	 */
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		
		return dao.executeQueryForList("SELECT usermessage.user_name,usermessage.user_photo,discussion.* FROM discussion,usermessage WHERE discussion.user_mail=usermessage.user_mail");
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  条件查询通过标签
	 */
	@Override
	public List<Map<String, Object>> queryByLabel(String dis_label) throws ClassNotFoundException, SQLException {
		
		String sql = "select * from Discussion where dis_label like ?";
//		return dao.executeQueryForList(sql);
		int[] types = new int[1];
		
		types[0] = Types.VARCHAR;
		
		Object[] values = new Object[1];
		
		values[0] = dis_label;
		
		return dao.executeQueryForList(sql, types, values);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @desc 更新数据库中的dis_likeUp字段值
	 */
	@Override
	public void updateLikeUp(String dis_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql1 = "select * from Discussion where dis_id=?";
		String val = (String) dao.executeQueryForMap(sql1, new int[]{Types.VARCHAR}, new Object[]{dis_id}).get("dis_likeUp");
		val = (Integer.parseInt(val)+1)+"";
		
		String sql2 = "update Discussion set dis_likeUp=? where dis_id=?";
		dao.executeUpdate(sql2, new int[]{Types.VARCHAR,Types.VARCHAR}, new Object[]{});
		
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc  添加帖子的方法
	 */
	@Override
	public void addForumPosts(String user_mail, String dis_text, String dis_way) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
			String sql = "insert into discussion(dis_id,user_mail,dis_text,dis_way) values(?,?,?,?)";
			int[] types = new int[4];
			types[0] = Types.VARCHAR;
			types[1] = Types.VARCHAR;
			types[2] = Types.VARCHAR;
			types[3] = Types.VARCHAR;
			Object[] values = new Object[4];
			values[0] = UUID.randomUUID().toString().substring(0,6);
			values[1] = user_mail;
			values[2] = dis_text;
			values[3] = dis_way;
			dao.executeUpdate(sql, types, values);
	}
	/**
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  通过user_mail 查询自己发送的帖子
	 */
	@Override
	public List<Map<String, Object>> queryByUserMail(String user_mail) throws ClassNotFoundException, SQLException {
		String sql = "select * from discussion where user_mail= '"+user_mail+"'";
		return dao.executeQueryForList(sql);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc  通过帖子的ID进行删除自己发过的帖子
	 */
	@Override
	public void deletePreownedById(String dis_id) throws ClassNotFoundException, SQLException {
			dao.executeUpdate("delete from discussion where dis_id = '"+dis_id+"'");
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @desc 通过ID对帖子进行留言
	 */
	@Override
	public void addLeaveMessage(String dis_id,String leave_text, String user_mail) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql  = "insert into leavemessage(leave_text,user_mail,dis_id)  values(?,?,?)  ";
		     
		int[] types = new int[3];
		types[0] = Types.VARCHAR;
		types[1] = Types.VARCHAR;
		types[2] = Types.VARCHAR;
		Object[] values = new Object[3];
		values[0] = leave_text;
		values[1] = user_mail;
		values[2] = dis_id;
		dao.executeUpdate(sql, types, values);
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc   查询留言
	 */
	@Override
	public List<Map<String, Object>> queryLeaveMessage(String dis_id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT u.user_name,u.user_photo,l.* FROM  usermessage u  RIGHT JOIN  leavemessage l   ON  u.user_mail= l.user_mail WHERE dis_id = '"+dis_id+"'";
			return dao.executeQueryForList(sql);
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc  添加帖子
	 */
	@Override
	public void addDisscuss(String user_mail, String listName, String dis_text) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
			String sql = "insert into discussion(dis_id,user_mail,dis_text,dis_way) values(?,?,?,?)";
			int[] types = new int[4];
			types[0] = Types.VARCHAR;
			types[1] = Types.VARCHAR;
			types[2] = Types.VARCHAR;
			types[3] = Types.VARCHAR;
			Object[] values = new Object[4];
			values[0] = UUID.randomUUID().toString().substring(0,6);
			values[1] = user_mail;
			values[2] = dis_text;
			values[3] = listName;
			dao.executeUpdate(sql, types, values);
	}
	/**
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 查询少量的条数
	 */
	@Override
	public List<Map<String, Object>> queryLittle(int page) throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("SELECT usermessage.user_name,usermessage.user_photo,discussion.* FROM discussion,usermessage WHERE discussion.user_mail=usermessage.user_mail LIMIT " + (page-1)*9 + ",9");
		
	}
}
