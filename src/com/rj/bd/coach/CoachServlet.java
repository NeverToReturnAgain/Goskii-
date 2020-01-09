package com.rj.bd.coach;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * @desc   教练的模块的C层
 * @author dell
 * @time   2020年1月2日
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/Skiings/coach.do")
public class CoachServlet extends HttpServlet{

	ICoachService service = new CoachServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			if(method.equals("queryAll")){
				this.queryAll(request,response);
			}else if(method.equals("queryLittle")){
				this.queryLittle(request,response);
			}else if(method.equals("addCoach")){
				this.addCoach(request,response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void addCoach(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String niseko_id = request.getParameter("niseko_id");
		String coach_name = request.getParameter("coach_name");
		String coach_teaching = request.getParameter("coach_teaching");
//		String coach_status = request.getParameter("coach_status");
		String coach_time = request.getParameter("coach_time");
		String grade = request.getParameter("grade");//评分
		
		service.addCoach(niseko_id,coach_name,coach_teaching,coach_time,grade);
	}

	/**
	 * @desc  根据页数查询
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void queryLittle(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		if(page<=0) page=1;
		List<Map<String, Object>> list = service.queryLittle(page);
		response.getWriter().print(JSONArray.fromObject(list));
	}

	/**
	 * @desc  查询所有
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		List<Map<String, Object>> list = service.queryAll();
//		System.out.println(list);
		response.getWriter().print(JSONArray.fromObject(list));
		
	}

	
}
