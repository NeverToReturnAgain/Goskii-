package com.rj.bd.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;

import com.rj.bd.register.RegisterServiceImpl;
import com.rj.bd.utils.CodeUtils;
import com.rj.bd.utils.EmailUtils;
import com.rj.bd.utils.ImgPeration;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Skiings/login.do")
public class loginServlet extends HttpServlet {
	ILoginService loginService = new LoginServiceImpl();
	HttpSession session;
	public String sendCode = "";
	private String findMail;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type,Token,Accept, Connection, User-Agent, Cookie");
		response.setHeader("Access-Control-Max-Age", "3628800");

		try {
			String method = request.getParameter("method");
			System.out.println("method:" + method);
			if (method.equals("login")) { // 登录
				this.login(request, response);
			} else if (method.equals("logOut")) { // 退出登录
				this.logOut(request, response);
			} else if (method.equals("updateUserPwd")) { // 修改密码
				this.updateUserPwd(request, response);
			} else if (method.equals("sendKeyCode")) {// 发送验证码
				this.sendKeyCode(request, response);
			} else if (method.equals("updatePage")) {
				this.updatePage(request, response);
			}  else if(method.equals("add")){
				System.out.println("进入了");
				String a = request.getParameter("imgBase64Data");
				String b = request.getParameter("add_text");
				String c = request.getParameter("add_biaoqian");
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				ImgPeration.imgSave(a,"D:/" + UUID.randomUUID().toString() + ".jpg");
				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	/**
	 * @desc 判断验证码是否准确,准确则跳转到修改密码界面
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void updatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-

		String code = request.getParameter("code");// 邮箱
		code = code.toUpperCase();
		if (!code.equals(this.sendCode)) {// 验证码正误判断
			response.getWriter().print("false");
			return;
		}

		response.getWriter().print(true);// 让前台跳转到输入密码界面
		// request.setAttribute("findMail", findMail);

	}

	/**
	 * @desc 先跳转到"忘记密码的界面",随后界面上显示输入邮箱,并且可以发送验证码,忘记密码找回时发送的验证码[直接调用注册模块的发送]
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 * @throws MessagingException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	private void sendKeyCode(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, FileNotFoundException, MessagingException, SQLException, IOException {

		String findMail = request.getParameter("user_mail");

		if (!new RegisterServiceImpl().userPresenceJudgment(findMail)) {// 判断用户是否存在,存在则终止
			response.getWriter().write("用户不存在");
			return;
		}
		System.out.println(findMail);
		String code = CodeUtils.createCode(6);// 生成6位验证码
		EmailUtils.createMimeMessage(request, findMail, code);

		this.sendCode = code;
		this.findMail = findMail;
		// response.getWriter().write("true");
	}

	/**
	 * @desc -修改密码
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void updateUserPwd(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		String user_mail = request.getParameter("user_mail");// 前台cookie功能未实现,只能用全局变量临时代替
		String user_pwd = request.getParameter("user_pwd");
		// String user_mail =
		// this.findMail;//等前台可以实现cookie存储时,修改updatePage方法同时注释该语句释放上一句
		loginService.UpdatePwd(user_mail, user_pwd);

		response.getWriter().write("true");

	}

	/**
	 * @desc 退出登录
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {

		session.invalidate();

		response.getWriter().write("true");

	}

	/**
	 * @desc 登录
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		// 设置响应
		response.setContentType("application/json;charset=utf-8");
		// 从登录页面接值
		String user_mail = request.getParameter("user_mail");
		System.out.println("user_mail:" + user_mail);
		String user_pwd = request.getParameter("user_pwd");
		System.out.println("user_pwd:" + user_pwd);
		// 从数据库中查询
		Map<String, Object> map_user = loginService.queryForMessage(user_mail, user_pwd);
		// 判断
		if (map_user == null) {
			response.getWriter().write("false");
			System.out.println("查无此人");
		} else {
			Cookie cookie = new Cookie("user_mail", user_mail);
			// System.out.println("当前的cookie:"+cookie);
			response.addCookie(cookie);
			//
			response.addHeader("Access-Control-Allow-Credentials", "true");

			//
			// 获取session对象
			session = request.getSession();
			// 将查询到的数据存入session作用域中
			session.setAttribute("map_user", map_user);
			// 获取session的ID
			response.getWriter().write("true");
			String id = session.getId();
			session.setAttribute("id", id);
			System.out.println("session的id:" + id);
		}
	}
	
	
	
    

	
	
	
	
	
	
}
