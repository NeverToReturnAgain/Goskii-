package com.rj.bd.skiresort;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc 雪场信息C层
 * @author dell
 * @time 2019年12月21日
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Skiings/skiresort.do")
public class SkiResortServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");

//		System.out.println(method);
		if (method.equals("registerPage")) {
			this.registerPage(request, response);// 转到注册页面
		} else if (method.equals("addSkiResort")) {
			this.addSkiResort(request, response);// 注册为滑雪场
		}

	}

	/**
	 * @desc 注册为滑雪场
	 * @param request
	 * @param response
	 */
	private void addSkiResort(HttpServletRequest request, HttpServletResponse response) {
		
		String niseko_name = request.getParameter("niseko_name");//滑雪场名字
		String niseko_photo = request.getParameter("niseko_photo");//滑雪场图片路径
		String niseko_address = request.getParameter("niseko_address");//滑雪场地址
		String niseko_tel = request.getParameter("niseko_tel");//滑雪场电话号码
		//<--验证过程-->
		
//		System.out.println(niseko_photo);
	}

	/**
	 * @desc  跳转到注册的界面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void registerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(666);
		request.getRequestDispatcher("/add_ski.jsp").forward(request, response);//测试用界面
		
	}

}
