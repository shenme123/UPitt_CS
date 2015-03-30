<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;">
		<form action="regist.do" method="post">
			<fieldset>
				<legend>注册</legend>
				用户名:<input name="username"/>
				<%
					String msg =
					 (String)request.getAttribute("regist_error");
				 %>
				<span class="s1"><%=(msg == null ? "" : msg)%></span>
				<br/>
				密码:<input type="password" name="pwd"/><br/>
				年龄:<input name="age"/><br/>
				<input type="submit" value="确定"/>
			</fieldset>
		</form>
	</body>
</html>