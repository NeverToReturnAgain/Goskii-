package com.rj.bd.privatemessage;
/**
 * @desc   私人消息的M层
 * @author dell
 * @time   2019年12月26日
 */

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

public class PrivateMessageServiceImpl implements PrivateMessageService{
Dao dao = new DaoImpl();
	@Override
	public List<Map<String, Object>> queryPriMessage(String type,String user_mail) throws ClassNotFoundException, SQLException {
		String sql = "SELECT information.*,usermessage.user_name FROM usermessage,information WHERE info_bywiter=? AND info_status LIKE ? AND information.user_mail=usermessage.user_mail";
		return dao.executeQueryForList(sql , new int[]{Types.VARCHAR,Types.VARCHAR}, new Object[]{user_mail,type});
	}
	/**\
	 * @desc  先根据消息id查询状态位,随后修改状态位
	 */
	@Override
	public void alterState(String info_id) throws ClassNotFoundException, SQLException {
		
		String info_status = (String) dao.executeQueryForMap("select * from information where info_id=" + info_id).get("info_status");
		
		String type = info_status.split("_")[0];
		
		dao.executeUpdate("update information set info_status='"+type +"_1' where info_id='" +info_id +"'");
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 删除一条
	 */
	@Override
	public void delete(String info_id) throws ClassNotFoundException, SQLException {
		dao.executeUpdate("delete from information where info_id = '"+info_id+"'");
		
		
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 删除所有的
	 */
	@Override
	public void delete(String status, String user_mail) throws ClassNotFoundException, SQLException {
		if(status==null) status="";
		dao.executeUpdate("delete from information where user_mail = '"+user_mail+"' and info_status like'"+ status+"_%'");
		
	}
	@Override
	public int selectAllMessageCount(String info_bywiter) throws ClassNotFoundException, SQLException {
		return dao.executeQueryForInt(
				"SELECT COUNT(*) FROM information WHERE info_status LIKE '2_0' OR info_status LIKE '1_0' AND info_bywiter='"+info_bywiter+"'"
				);
		
	}

}
