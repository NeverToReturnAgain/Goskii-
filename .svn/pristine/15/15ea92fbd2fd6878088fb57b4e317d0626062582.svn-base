package com.rj.bd.returnImg;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.rj.bd.utils.ImgPeration;

/**
 * @desc   请求图片的类
 * @author dell
 * @time   2019年12月29日
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/Skiings/returnimg.do")
public class ReturnImgServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *	需要一个参数:[imgname=?]
		 *	请求的地址:--->
		 *		"http://" +InetAddress.getLocalHost().getHostAddress() + ":"+request.getServerPort() + request.getContextPath() + "/Skiings/returnimg.do?imgname=" + imgName;
		 *		请求绝对路径地址:--->
		 *			http://10.2.32.1:8089/GoSkiings/Skiings/returnimg.do?imgname=
		 *	默认存放路径: --->
		 *		请求地址: request.getServletContext().getRealPath("/") + "WEB-INF/files";
		 *		张windows系统绝对路径地址:--->
		 *			D:\eclipse_ECL\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\GoSkiings\WEB-INF\files
		 */
		try {
			ImgPeration.imgReturn(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
	}

	
	
	
}
