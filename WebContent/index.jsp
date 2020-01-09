<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <script  src="<%=request.getContextPath()%>/JS/jQuery/jquery-1.4.4.js" ></script>
 <script type="text/javascript" >
        	//点击登录
        	function login(){
					var user_mail = $("#user_mail").val();
					var user_pwd = $("#user_pwd").val();
					alert("运行到这了");
					$.ajax({
						type:"post",
						url:"<%=request.getContextPath()%>/Skiings/login.do?method=login",
						data:{"user_mail":user_mail,"user_pwd":user_pwd},
						dataType: 'json',
						async:false,
						success:function(data){
							if(!data){
								alert("没有这个人");
							}
							else if(data){
								alert("登录成功");
								alert("邮箱账号："+user_mail);
								var strUrl = "<%=request.getContextPath() %>/Skiings/user.do?method=queryForUserMessage&user_mail='"+user_mail+"'";
								window.location.href=strUrl;
							}
						},
						error:function(){
						//服务器连接失败
						alert("失败");
						},
						beforeSend:function(){//在success之前就进行了
						//操作
						alert("在success之前就进行了");
						},
						complete:function(){//在success之后就进行
						//操作
						alert("完成");
						}
					});
        	}
        
        </script>
</head>
<body>
			<form  id="form1" action="index.jsp" method="post" >
    			<input id="user_mail" name="user_mail" type="text" value=""/>
    			<input id="user_pwd" name="user_pwd" type="text" value=""/>
    			<input onclick="login()" type="submit" value="登录 11"/>
    		</form>
    		
    		<a href="<%=request.getContextPath() %>/register.jsp">6666666666666</a>
    		<a href="<%=request.getContextPath() %>/Skiings/user.do?method=queryForUserMessage">图片</a>
    		<a href="<%=request.getContextPath() %>/wode.jsp">我的界面</a>
    		<a href="<%=request.getContextPath() %>/Skiings/skiresort.do?method=registerPage">滑雪场注册</a>
</body>
</html>