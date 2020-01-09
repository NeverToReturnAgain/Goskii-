package com.rj.bd.lease;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * @desc  租赁信息的C层
 * @author dell
 * @time 2019年12月28日
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Skiings/lease.do")
public class LeaseServlet extends HttpServlet {

	LeaseService lease = new LeaseServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		try {
			if (method.equals("queryAll")) {
				this.queryAll(request, response);
			} else if (method.equals("addLeaseInfo")) {
				this.addLeaseInfo(request, response);
			}else if(method.equals("deleteLeaseInfo")){
				this.deleteLeaseInfo(request,response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	/**
	 * @desc  删除lease_info表中的数据--->随后删除lease中的信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private void deleteLeaseInfo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String lease_id = request.getParameter("lease_id");
		lease.deleteLeaseInfo(lease_id);
		
	}
	/**
	 * @desc  添加租赁信息---->只有邮箱和id
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private void addLeaseInfo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String user_mail = request.getParameter("user_mail");
		String lease_id = UUID.randomUUID().toString();
		lease.addLeaseInfo(lease_id,user_mail);
		addLease(request,response,lease_id);
	}

	/**
	 * @desc  添加租赁{详细}信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private void addLease(HttpServletRequest request, HttpServletResponse response,String lease_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		
		String lease_introduction = request.getParameter("lease_introduction");
		
		
		
		
		String lease_img = request.getParameter("lease_img");//功能有毒--->还没实现
		
		
		
		
		String lease_brand = request.getParameter("lease_brand");
		String lease_price = request.getParameter("lease_price");
		String lease_percent = request.getParameter("lease_percent");
		String lease_color = request.getParameter("lease_color");
		
		lease.addLease(lease_id,lease_introduction,lease_img,lease_brand,lease_price,lease_percent,lease_color);
		
		
	}

	/**
	 * @desc 查询所有的租赁信息
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String lease_brand = request.getParameter("lease_brand");
		String lease_color = request.getParameter("lease_color");
		String lease_price = request.getParameter("lease_price");
		String lease_percent = request.getParameter("lease_percent");

		List<Map<String, Object>> list = lease.queryAll(lease_brand, lease_color, lease_price, lease_percent);
		// System.out.println(list);

		response.getWriter().print(JSONArray.fromObject(list));
	}

}
