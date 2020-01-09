package com.rj.bd.feedback;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc   
 * @author dell
 * @time   2020年1月2日
 */
@SuppressWarnings("serial")
public class FeedBack extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if(method.equals("")){
			
		}
	
	}

	
	
}
