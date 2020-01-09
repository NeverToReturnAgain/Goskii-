package com.rj.bd.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

/**
 * @desc 邮件发送的工具类
 * @author WW
 * @time 2019年12月13日下午3:12:12
 */
public class EmailUtils {
	public static String sendEmailAccount;// 自己的邮箱
	public static String sendEmailPwd;// 邮箱授权码
	static {
		try {
			Map<String, Object> map = PropertuUtils.getInfoFromProperties("mail.properties");
			sendEmailAccount = (String) map.get("emailFrom");
			sendEmailPwd = (String) map.get("emialFromAuthorization");
		} catch (IOException e) {
			System.out.println("IO异常。。。。。");
		}
	}

	/**
	 * @desc 抽取出一个公共的方法：目的是获取session会话对象
	 */
	private static Session getSession() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");// 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", "smtp.163.com"); // 发件人的邮箱的 SMTP// 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		Session session = Session.getInstance(props);// 2.创建session会话对象
//		session.setDebug(true);// 开启debug调试的模式，可以打印出发送的log
		return session;
	}

	/**
	 * @desc 创建一个MimeMessage对象，并声明发件人
	 */
	private static MimeMessage ChuangJian(Session session, String receiveMail, String emailSubject)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendEmailAccount, "发送者的昵称", "utf-8"));// 3.设定发件人
		message.setRecipient(RecipientType.TO, new InternetAddress(receiveMail, "接收人", "utf-8"));// 5.设定接收人
		message.setSubject(emailSubject);// 6.设定主题
		return message;
	}

	/**
	 * @desc 添加附件和图片
	 */
	private static MimeMessage Files(String emailText, String fileUrl, MimeMessage message, MimeBodyPart txt)
			throws MessagingException, UnsupportedEncodingException {
		txt.setContent(emailText,"text/html;charset=UTF-8");
		MimeBodyPart attachment = new MimeBodyPart();
		DataHandler dh2 = new DataHandler(new FileDataSource(fileUrl));// 读取本地文件
		attachment.setDataHandler(dh2);// 将附件数据添加到"节点"
		if (dh2.getName().substring(dh2.getName().lastIndexOf('.')+1).equals("jpg")) {
			attachment.setContentID("c.png");
		}else{
			attachment.setFileName(MimeUtility.encodeText(dh2.getName()));// 设置附件的文件名（需要编码）
		}
		MimeMultipart mm = new MimeMultipart();// 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
		mm.addBodyPart(txt);
		mm.addBodyPart(attachment); // 如果有多个附件，可以创建多个多次添加
		mm.setSubType("mixed"); // 混合关系
		message.setContent(mm);// 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）// 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
		return message;
	}
	
	/**
	 * @desc 抽取出来的公共的方法：目的是讲设定时间，保存设计，获取传递对象，连接SMTP,发送，关闭等步骤抽取为一个方法
	 */
	private static void saveAndSendMessage(Session session, MimeMessage message)
			throws MessagingException, NoSuchProviderException {
		message.setSentDate(new Date());// 8.设定时间
		message.saveChanges();// 9.保存设置
		Transport transport = session.getTransport();// 10.获取传输对象
		transport.connect(sendEmailAccount, sendEmailPwd);// 11.连接上SMTP邮件服务器
		transport.sendMessage(message, message.getAllRecipients());// 12.发送邮件
		transport.close();// 13.关闭连接
	}

	/**
	 * @desc 1.创建一封简单的邮件
	 */
	public static void createMimeMessage(String sendMail, String receiveEmail)
			throws MessagingException, UnsupportedEncodingException {
		String emailSubject = "这是我的第一封邮件";
		Session session = getSession();
		MimeMessage message = ChuangJian(session, receiveEmail, emailSubject);
		message.setContent("正文：Hello Email", "text/html;charset=utf-8");
		saveAndSendMessage(session, message);
	}

	/**
	 * @desc 2.发送还有验证码的邮件
	 */
	public static void createMimeMessage(HttpServletRequest request, String receiveEmail, String code)
			throws UnsupportedEncodingException, MessagingException {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "";
		String emailSubject = "[去滑雪]平台 消息";
		Session session = getSession();
		MimeMessage message = ChuangJian(session, receiveEmail, emailSubject);
		String context = "<div>您的验证码为:[ " + code + " ],如果不是您本人的操作,请忽略本条消息</div>";
		message.setContent(context, "text/html;charset=utf-8");
		saveAndSendMessage(session, message);
	}
	/**
	 * @desc 	联系我们
	 */
	public static void createMimeMessage(HttpServletRequest request, String receiveEmail,String name,String Subject,String message,String Email)
			throws UnsupportedEncodingException, MessagingException {
		
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+ "";
		String emailSubject = Subject;
		Session session = getSession();
		MimeMessage message2 = ChuangJian(session, receiveEmail, emailSubject);
		String context = "用户-'"+name+"':Message:'"+message+"'   用户邮箱：'"+Email+"'   ";
		message2.setContent(context, "text/html;charset=utf-8");
		saveAndSendMessage(session, message2);
	}

	/**
	 * @desc 3.发送带有图片的邮件
	 */
	public static void createMimeMessage(String receiveEmail, String emailSubject, String context, String imageUrl)
			throws UnsupportedEncodingException, MessagingException {
//		System.out.println("接收者："+receiveEmail);
//		System.out.println("标题："+emailSubject);
//		System.out.println("内容"+context);
//		System.out.println("图片路径"+imageUrl);
		Session session = getSession();
		MimeMessage message = ChuangJian(session, receiveEmail, emailSubject);
		MimeBodyPart txt = new MimeBodyPart();// 6.1设定img标签
		context="" + context + "\n<img src='cid:c.png' />";// 要显示图片就用content不要用text datahandler指向的资源 要加上cid:前缀 不然不显示
		MimeBodyPart img = new MimeBodyPart();// 6.2加载本地的图片资源
		message = Files(context, imageUrl, message, img);
		saveAndSendMessage(session, message);
	}

	/**
	 * @desc 4.发送带有附件的邮件
	 */
	public static void createMimeMessages(String receiver, String emailSubject, String emailText, String fileUrl)
			throws UnsupportedEncodingException, MessagingException {
		Session session = getSession();
		MimeMessage message = ChuangJian(session, receiver, emailSubject);
		MimeBodyPart txt = new MimeBodyPart();
		message = Files(emailText, fileUrl, message, txt);
		saveAndSendMessage(session, message);
	}
}
