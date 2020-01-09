package com.rj.bd.coach;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rj.bd.dao.Dao;
import com.rj.bd.dao.DaoImpl;

/**
 * @desc   
 * @author dell
 * @time   2020年1月2日
 */
public class CoachServiceImpl implements ICoachService{

	Dao dao = new DaoImpl();
	@Override
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return dao.executeQueryForList("select * from coach");
	}
	/**
	 * @desc  查询一定的条数
	 */
	@Override
	public List<Map<String, Object>> queryLittle(int page) throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("select * from page LIMIT " + (page-1)*4 + ",4");
	}
	@Override
	public void addCoach(String niseko_id, String coach_name, String coach_teaching, String coach_time, String grade) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		String sql = "insert into coach values(?,?,?,?,?,?,?)";
		
		int[] types = new int[7];
		for (int i = 0; i < types.length; i++) {
			types[i] = Types.VARCHAR;
		}
		Object[] values = {
				UUID.randomUUID().toString(),
				niseko_id,
				coach_name,
				coach_teaching,
				"0",
				coach_time,
				grade
				
				
		};
		dao.executeUpdate(sql , types , values );
	}


}
