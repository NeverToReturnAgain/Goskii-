package com.rj.bd.discussion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDiscussionService {

	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> queryByLabel(String dis_label) throws ClassNotFoundException, SQLException;

	void updateLikeUp(String dis_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	void addForumPosts(String user_mail, String dis_text, String dis_way) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<Map<String, Object>> queryByUserMail(String user_mail) throws ClassNotFoundException, SQLException;

	void deletePreownedById(String dis_id) throws ClassNotFoundException, SQLException;

	void addLeaveMessage(String dis_id, String leave_text, String user_mail) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	List<Map<String, Object>> queryLeaveMessage(String dis_id) throws ClassNotFoundException, SQLException;

	void addDisscuss(String user_mail, String listName, String dis_text) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<Map<String, Object>> queryLittle(int page) throws ClassNotFoundException, SQLException;

}
