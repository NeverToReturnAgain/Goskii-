package com.rj.bd.discussion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.rj.bd.utils.ImgPeration;
import com.rj.bd.utils.ToJson;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Skiings/discussion.do")
public class DiscussionServlet extends HttpServlet {
	IDiscussionService discussionService = new DiscussionServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String method = request.getParameter("method");
			if (method.equals("queryAll")) { // 查询数据库所有数据
				this.queryAll(request, response);
			} else if (method.equals("queryByLabel")) { // 通过dis_label（标签）执行查询功能
				this.queryByLabel(request, response);
			} else if (method.equals("likeUp")) { // 通过dis_label（标签）执行查询功能
				this.likeUp(request, response);
			} else if (method.equals("addDisscuss")) { // 添加帖子
				this.addDisscuss(request, response);
			} else if (method.equals("queryByUserMail")) { // 通过当前登录的user_mail
															// 进行查询自己发过的帖子
				this.queryByUserMail(request, response);
			} else if (method.equals("deletePreownedById")) { // 通过帖子的ID进行删除自己发过的帖子
				this.deletePreownedById(request, response);
			} else if (method.equals("addLeaveMessage")) { // 给帖子留言
				this.addLeaveMessage(request, response);
			} else if (method.equals("queryLeaveMessage")) { // 查询留言
				this.queryLeaveMessage(request, response);
			} else if(method.equals("queryLittle")){
				this.queryLittle(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @desc  通过页数查询
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void queryLittle(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String getPage = request.getParameter("page");
		if (getPage==null || getPage == "0") getPage = "1";
		int page = Integer.parseInt(getPage);
		if(page==0)page=1;
		List<Map<String, Object>> listLittle = discussionService.queryLittle(page);
		
		JSONArray json = ToJson.ListToJson(listLittle);
		response.getWriter().print(json);
		
	}

	/**
	 * @desc 查询当前贴子所有留言
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void queryLeaveMessage(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String dis_id = request.getParameter("dis_id");
		List<Map<String, Object>> listMessage = discussionService.queryLeaveMessage(dis_id);
		System.out.println("查询出来的当前贴子所有留言:" + listMessage);
		JSONArray json = ToJson.ListToJson(listMessage);
		response.getWriter().print(json);

	}

	/**
	 * @desc 给帖子进行留言
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void addLeaveMessage(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String dis_id = request.getParameter("dis_id");
		String leave_text = request.getParameter("leave_text"); // 获取留言内容
		String user_mail = request.getParameter("user_mail");
		discussionService.addLeaveMessage(dis_id, leave_text, user_mail);
		response.sendRedirect(
				request.getContextPath() + "/Skiings/discussion.do?method=queryLeaveMessage&dis_id=" + dis_id + "");
	}

	/**
	 * @desc 通过帖子的ID进行删除自己发过的帖子
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void deletePreownedById(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String dis_id = request.getParameter("dis_id");
		String user_mail = request.getParameter("user_mail");
		discussionService.deletePreownedById(dis_id);
		response.sendRedirect(request.getContextPath() + "/Skiings/discussion.do?method=queryByUserMail");
	}

	/**
	 * @desc 通过当前登录的user_mail 进行查询自己发过的帖子
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void queryByUserMail(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String user_mail = request.getParameter("user_mail");
		List<Map<String, Object>> listMessage = discussionService.queryByUserMail(user_mail);
		JSONArray json = ToJson.ListToJson(listMessage);
		response.getWriter().print(json);

	}

	/**
	 * @desc 在社区添加贴子
	 * @param request
	 * @param response
	 * @throws FileUploadException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void addDisscuss(HttpServletRequest request, HttpServletResponse response)
			throws FileUploadException, IOException, ClassNotFoundException, SQLException {

		String user_mail = request.getParameter("user_mail");
		String dis_text = request.getParameter("dis_text");
		// 设置基础编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String listName = ImgPeration.imgSave(request,response);//目前还少多张图片上传(只能一张)
		// 调用M层的方法存储数据
		discussionService.addDisscuss(user_mail, listName, dis_text);
//		response.sendRedirect(request.getContextPath() + "/Skiings/discussion.do?method=queryAll");
		
		response.getWriter().print(true);

	}

	/**
	 * @desc 点赞功能
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void likeUp(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String dis_id = request.getParameter("dis_id");
		discussionService.updateLikeUp(dis_id);

	}

	/**
	 * @desc 通过标签查询出想要的数据
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void queryByLabel(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String dis_label = request.getParameter("dis_label");
		List<Map<String, Object>> list_part = discussionService.queryByLabel(dis_label);
		JSONArray json = ToJson.ListToJson(list_part);
		response.getWriter().print(json);
	}

	/**
	 * @desc 查询所有帖子
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	private void queryAll(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		
		// 从数据库查询所有的数据
		List<Map<String, Object>> listAll = discussionService.queryAll();
		JSONArray json = ToJson.ListToJson(listAll);
		response.getWriter().print(json);
		System.out.println("json:" + json);

	}
	
	
}
