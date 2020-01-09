<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="JS/jQuery/jquery-1.4.4.js"></script>
<script type="text/javascript">
	var sendCode = function() {
		var user_mail = $("#user_mail").val();
		$.ajax({
			
			type:"post",
			url:"<%=request.getContextPath()%>/Skiings/register.do?method=sendKeyCode",
			async:true,
			data:({"user_mail":user_mail}),
			success: function (data) {
				if(!data){
					return false;
				}
				else{
					
	//				window.location.href='<%=request.getContextPath()%>/Skiings/register.do?method=loginPage'
					
				}
//				alert(data)
		    }
			
			
		});
		
	}



	var sub = function() {
		var user_mail = $("#user_mail").val();
		//alert(manager_name)
		
		var user_pwd = $("#user_pwd").val();
		var code = $("#code").val();
		alert(666)
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/Skiings/register.do?method=addUser",
			async:false,
			data:({"user_mail":user_mail, "user_pwd":user_pwd,"code":code}),
			success: function (data) {
				alert(data)
				window.location.href='<%=request.getContextPath()%>/Skiings/register.do?method='
								+ data;
					}

				});

	}
</script>

</head>

<body>
	======= 邮箱
	<input id="user_mail" type="text" value="lucky_dog0@163.com" name="user_mail"> 密码
	<input id="user_pwd" type="text" value="123456" name="user_pwd">
	验证码
	<input id="code" type="text" value="" name="code">
	<input id="sendCode" type="button" value="发送验证码" onclick="sendCode()">
	<input id="sub" type="button" value="注册" onclick="sub()">
	=======
</body>
</html>