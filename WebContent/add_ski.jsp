<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加雪场信息</title>

<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jQuery/jquery-1.4.4.js" ></script>
<script>
	var sub = function() {
		var niseko_name = $("#niseko_name").val();
		var niseko_photo = $("#niseko_photo").val();
		var niseko_address = $("#niseko_address").val();
		var niseko_tel = $("#niseko_tel").val();
		
		
		//alert(666)
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath() %>/Skiings/skiresort.do?method=addSkiResort",
			async:true,
			data:({"niseko_name":niseko_name, "niseko_photo":niseko_photo,"niseko_address":niseko_address,"niseko_tel":niseko_tel}),
			success: function (data) {
				//alert(data)
				//window.location.href='<%=request.getContextPath() %>/Skiings/register.do?method=' + data;
		    }
		});
	}
</script>
</head>
<body>
雪场名字<input type="text" name="" id="niseko_name" value="" />
<br />
雪场图片 <input type="file" name="" id="niseko_photo" value="" />
<br />
雪场地址<input type="text" name="" id="niseko_address" value="" />
<br />
雪场电话<input type="text" name="" id="niseko_tel" value="" />

<input type="button" value="666" onclick="sub()">
</body>
</html>