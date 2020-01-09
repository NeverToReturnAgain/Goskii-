package com.rj.bd.privatemessage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rj.bd.utils.ToJson;

/**
 * @desc   私人消息的c层
 * @author dell
 * @time   2019年12月26日
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/Skiings/privatemessage.do")
public class PrivateMessageServlet extends HttpServlet{

	PrivateMessageService primessage = new PrivateMessageServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			if(method.equals("queryNotice")){
//				System.out.println(111);
				this.queryNotice(request,response);
			}else if(method.equals("queryAll")){
				this.queryAll(request,response);
			}else if(method.equals("alterState")){
				this.alterState(request,response);
			}else if(method.equals("deleteinfo")){
				this.deleteinfo(request,response);
				
			}else if(method.equals("selectMessageCount")){
				this.selectMessageCount(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * @desc  查询未读消息总条数
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void selectMessageCount(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String info_bywiter = request.getParameter("info_bywiter");
		int count = primessage.selectAllMessageCount(info_bywiter);
		
		response.getWriter().print(count);
	}
	
	/**
	 * @desc  删除消息
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void deleteinfo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		String type = request.getParameter("type");
		
		if(type.equals("all")){
			String status = request.getParameter("status");
			String user_mail = request.getParameter("user_mail");
			primessage.delete(status,user_mail);
			
		}else if(type.equals("one")){
			String info_id = request.getParameter("info_id");
			primessage.delete(info_id);
		}
		
	}
	/**
	 * @desc 修改消息的状态位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void alterState(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String info_id = request.getParameter("info_id");
		
		primessage.alterState(info_id);
//		System.out.println(info_id);
		response.getWriter().print(true);
	}
	/**
	 * @desc  发送所有查询到的[通知+私信]发送
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String user_mail = request.getParameter("user_mail");
		List<Map<String, Object>> list_notice = primessage.queryPriMessage("1%",user_mail);
		List<Map<String, Object>> list_private = primessage.queryPriMessage("2%",user_mail);
		List<List<Map<String, Object>>> list = new ArrayList<List<Map<String, Object>>>(){{
			add(list_notice);
			add(list_private);
		}};
//		System.out.println(list);
		response.getWriter().print(ToJson.ListToJson(list));
	}
	/**
	 * @desc  根据邮箱查询所有的给该用户发送的通知
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryNotice(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String user_mail = request.getParameter("user_mail");
		List<Map<String, Object>> list = primessage.queryPriMessage("1%",user_mail);
//		System.out.println();
		
//		list.add(new HashMap<String, Object>(){{
//			put("ifList",ifList(list));
//			
//		}});
		
		response.getWriter().print(ToJson.ListToJson(list));
//		System.out.println(list);
	}

	public boolean ifList(List<Map<String, Object>> list){
		for (Map<String, Object> map : list) {
			if(map.get("info_status").equals("1_0")) return true;
		}
		return false;
		
	}
	 
	
}
