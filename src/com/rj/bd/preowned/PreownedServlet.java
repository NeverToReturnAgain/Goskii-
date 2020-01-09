package com.rj.bd.preowned;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.rj.bd.utils.ToJson;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/Skiings/preowned.do")
public class PreownedServlet extends HttpServlet {
IPreownedService  preownedService = new PreownedServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
					String method = request.getParameter("method");
					if(method.equals("addPreowned")){ //添加二手商品
						this.addPreowned(request,response);
					}
					else if(method.equals("queryAllMessage")){ //查询商品所有信息+发布商品的用户的信息
						this.queryAllMessage(request,response);
					}
					else if(method.equals("queryMessageById")){ //通过ID查询详细信息
						this.queryMessageById(request,response);
					}
					else if(method.equals("queryMessageByType")){ //通过商品类型查询详细信息
						this.queryMessageByType(request,response);
					}
					else if(method.equals("queryByUserMail")){ //通过当前登录的user_mail 进行查询
						this.queryByUserMail(request,response);
					}
					else if(method.equals("deletePreownedById")){ //通过商品的ID进行删除商品
						this.deletePreownedById(request,response);
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	/**
	 * @desc  通过当前登录的user_mail 进行查询
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryByUserMail(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
				String user_mail = request.getParameter("user_mail");
				List<Map<String,Object>> listMessage = preownedService.queryMessageByUserMail(user_mail);
				JSONArray json = ToJson.ListToJson(listMessage);
				response.getWriter().print(json);
	}
	/**
	 * @desc  通过商品的ID进行删除商品
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void deletePreownedById(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		System.out.println("进入了删除方法");
		String preowned_id = request.getParameter("preowned_id");
		preownedService.deletePreownedById(preowned_id);
		response.sendRedirect(request.getContextPath()+"/Skiings/preowned.do?method=queryByUserMail");
	}   
	/**
	 * @desc  通过商品类型查询商品
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryMessageByType(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
			String preownedd_list_type = request.getParameter("preownedd_list_type");
			
			List<Map<String,Object>> listMessage = preownedService.queryAllMessageByType(preownedd_list_type);
			
			JSONArray json = ToJson.ListToJson(listMessage);
			response.getWriter().print(json);
	}
	/**
	 * @desc  查询所有信息
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryAllMessage(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
			//需要获取头像 姓名 介绍 新旧 价格 	图片 
		List<Map<String,Object>> listMessage = preownedService.queryAllMessage();
		
		System.out.println("查询的商品信息："+listMessage);
		
		JSONArray json = ToJson.ListToJson(listMessage);
		response.getWriter().print(json);
	}
	/**
	 * @desc  通过ID查询详细信息
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void queryMessageById(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		//获取前台的数据
			String preowned_id = request.getParameter("preowned_id");
			//通过ID获取信息
				List<Map<String,Object>> listMessage = preownedService.queryMessageById(preowned_id);
				//将查询到的list集合转为json格式
				JSONArray json = ToJson.ListToJson(listMessage);
				response.getWriter().print(json);
				
 	}

	/**
	 * @desc  添加二手产品的方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws FileUploadException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void addPreowned(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException, ClassNotFoundException, SQLException {
			//设置编码和格式
			response.setContentType("text/html;charset=utf-8");
			//获取要添加的值
			String user_mail = request.getParameter("user_mail");
			String[] preowned_list_picture = request.getParameterValues("preowned_list_picture");
			String preowned_list_introduction = request.getParameter("preowned_list_introduction");
			String preowned_list_type = request.getParameter("preowned_list_type");
			String preowned_list_pirce = request.getParameter("preowned_list_pirce");
			String preowned_list_percent = request.getParameter("preowned_list_percent");
			//定义变量
			String fileSaveName = null; //图片保存的名字
			List<FileItem> formItemsList = null;
			//设定图片保存在服务器上的路径
			String path = this.getServletContext().getRealPath("/")+"WEB-INF/PreownedImage";
			System.out.println("图片存储路径："+path);
			//根据路径名创建一个File实例，其目的是创建一个存储图片的路径
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
			}
			//将ruquest对象在factory工厂中最终变成FileItem
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//使用ServletFileUpload(文件上传)解析器解析上传数据，
			//解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("upload::"+upload);
			
			//获取解析结果的list
			formItemsList = upload.parseRequest(request);
			
			System.out.println("测验的数据的长度："+formItemsList.size());
			String listName ="";
			//因为有多张图片，所以我们通过循环进行添加
			for (int i = 0; i < formItemsList.size(); i++) {
				
				if(formItemsList!=null &&formItemsList.size()>0){
					
						if(!(formItemsList.get(i).isFormField())){
							String fileName = formItemsList.get(i).getName();//获取文件的全名
							String prefix =fileName.substring(fileName.lastIndexOf(".")+1); //获取后缀名
//							System.out.println("获取的后缀名："+prefix);
							//随机生成图片的名字
							String id = UUID.randomUUID().toString();
							fileSaveName = id+"."+prefix;
							//调用fileUtils工具类的方法
							FileUtils.copyInputStreamToFile(formItemsList.get(i).getInputStream(), new File(path+"/"+fileSaveName));	
						}
				}
				if(!(i==2)){
					listName += fileSaveName+",";
				}
				else{
					listName += fileSaveName;
				}
			}
			System.out.println("要保存到数据库的图片的名字的字符串："+listName);
			//调用M层的方法实现将修改后的信息保存到数据库
			preownedService.addPreowned(user_mail,listName, preowned_list_introduction,
					preowned_list_type, preowned_list_pirce,preowned_list_percent);
			
			response.sendRedirect(request.getContextPath()+"/Skiings/preowned.do?method=queryAllMessage");
			
	}

}
