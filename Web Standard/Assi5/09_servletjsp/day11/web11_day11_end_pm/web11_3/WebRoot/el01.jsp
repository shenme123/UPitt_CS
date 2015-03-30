<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		username:<%
			//User user = (User)request.getAttribute("user");
			//out.println(user.getUsername());
		 %><br/>
		 使用el表达式，比直接写java代码输出，优点是
		 <br/>会将null转换成""输出，另外，找不到对象，
		 <br/>不会报空指针异常。
		 username:${user.username}
		 
		 
		 
		 
	</body>
</html>