package com.rj.bd.privatemessage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc   私人消息的M层
 * @author dell
 * @time   2019年12月26日
 */
public interface PrivateMessageService {

	List<Map<String, Object>> queryPriMessage(String type, String user_mail) throws ClassNotFoundException, SQLException;

	void alterState(String info_id) throws ClassNotFoundException, SQLException;

	void delete(String info_id) throws ClassNotFoundException, SQLException;

	void delete(String status, String user_mail) throws ClassNotFoundException, SQLException;

	int selectAllMessageCount(String info_bywiter) throws ClassNotFoundException, SQLException;

}
