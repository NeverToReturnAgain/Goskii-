package com.rj.bd.coach;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc   
 * @author dell
 * @time   2020年1月2日
 */
public interface ICoachService {

	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;

	List<Map<String, Object>> queryLittle(int page) throws ClassNotFoundException, SQLException;

	void addCoach(String niseko_id, String coach_name, String coach_teaching, String coach_time, String grade) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;


}
