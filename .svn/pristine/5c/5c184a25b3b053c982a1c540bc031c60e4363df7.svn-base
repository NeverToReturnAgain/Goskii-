package com.rj.bd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Decoder;

/**
 * @desc
 * @author dell
 * @time 2019年12月29日
 */
public class ImgPeration {

	/**
	 * @desc 图片的保存-->保存到后台
	 * @param request
	 * @param response
	 * @return
	 * @throws FileUploadException
	 * @throws IOException
	 */
	public static String imgSave(HttpServletRequest request, HttpServletResponse response)
			throws FileUploadException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String filePath = null; // 文件的路径
		String fileName = null; // 文件的名字
		String fileSaveName = null; // 文件要保存的名字 UUID+prefix
		String prefix = null; // 前缀名

		// 得到上传文件的保存目录 将上传的文件存放于WEB_INF目录下，不允许外界直接访问，保证撒谎奶盖茶UN文件爱你的安全
		String realPath = request.getServletContext().getRealPath("/") + "WEB-INF/files";
		System.out.println("文件存放的位置" + realPath);

		// 设置临时目录，上传文件大于缓冲区则先放于临时目录中
		String tempPath = "E:/tempPath";
		System.out.println("临时文件存放位置：" + tempPath);

		// 判断目录是否存在，不存在则创建
		File file = new File(realPath);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("目录或文件不存在");
			file.mkdir();
		}

		// 判断临时目录是否存在，不存在则创建
		File file2 = new File(tempPath);
		if (!file2.exists() && !file2.isDirectory()) {
			System.out.println("临时目录或文件不存在");
			file2.mkdir();
		}

		// 文件开始上传
		// 1.创建factory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置上传文件的临时目录
		factory.setRepository(file2);
		// 2.核心操作类：创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传"文件名"的中文乱码
		upload.setHeaderEncoding("utf-8");
		// 3.判断enctype :判断提交上来的数据是否是上传表单的数据
		if (!upload.isMultipartContent(request)) {
			System.out.println("不是上船文件，终止交易");
			return null;
		}
		// 获取输入项
		// 限制大哥上传文件大小
		// upload.setFileSizeMax(1024*1024*4);
		// 限制总上传文件大小
		// upload.setSizeMax(1024*1024*6);
		// 4.使用ServletFileUpload解析器解析数据，解析结果返回一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> fileItems = upload.parseRequest(request);
		System.out.println("输出：" + fileItems);
		String listName = "";
		for (FileItem fileItem : fileItems) {
			fileName = fileItem.getName(); // 获取文件的全名
			prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println("文件的尾缀:" + prefix);
			fileName = UUID.randomUUID().toString();
			fileSaveName = fileName + "." + prefix;
			// 拼接上传路径，存放路径+上传的文件名
			filePath = realPath + "/" + fileSaveName;
			System.out.println("filePath:" + filePath);
			request.setAttribute("filePath", filePath);
			FileUtils.copyInputStreamToFile(fileItem.getInputStream(), new File(filePath));
			// 将文件的名字存入长字符串
			listName += fileSaveName + ",";
		}

		return listName;

	}

	/**
	 * @desc  以base64流方式直接储存
	 * @param base64str
	 * @param savepath
	 * @return
	 * @throws IOException
	 */
	public static boolean imgSave(String base64str, String savepath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
		
		if(savepath==null)
			return false;
		
		
		if (base64str == null) // 图像数据为空
			return false;
		// System.out.println("开始解码");
		BASE64Decoder decoder = new BASE64Decoder();

		// Base64解码
		byte[] b = decoder.decodeBuffer(base64str);
		// System.out.println("解码完成");
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {// 调整异常数据
				b[i] += 256;
			}
		}
		// System.out.println("开始生成图片");
		// 生成jpeg图片
		OutputStream out = new FileOutputStream(savepath);
		out.write(b);
		out.flush();
		out.close();
		return true;

	}

	/**
	 * @的市场 图片返回给前台
	 * @param request
	 * @param response
	 * @throws FileUploadException
	 * @throws IOException
	 */
	public static void imgReturn(HttpServletRequest request, HttpServletResponse response)
			throws FileUploadException, IOException {

		String imgname = request.getParameter("imgname");
		if(imgname==null || imgname.equals("")) imgname="default.gif";
		String path = request.getServletContext().getRealPath("/") + "WEB-INF/files/";
		// System.out.println("path---->"+path);
		File file = new File(path + imgname);
		if(!file.exists()) file = new File(path + "default.gif");
		FileInputStream fileInputStream = new FileInputStream(file);
		// System.out.println("fileInputStream----->"+fileInputStream);
		response.setContentType("image/jpg"); // 设置返回的文件类型
		response.setHeader("Access-Control-Allow-Origin", "*");// 设置该图片允许跨域访问
		IOUtils.copy(fileInputStream, response.getOutputStream());

	}
}
