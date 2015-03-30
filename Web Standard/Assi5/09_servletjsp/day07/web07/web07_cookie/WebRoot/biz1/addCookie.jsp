<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%
	Cookie c = new Cookie("company","tarena");
	//设置cookie的路径，以确保
	//当某个组件创建了cookie，其它组件都能访问到
	c.setPath("/web07_cookie");
	response.addCookie(c);
	out.println("添加cookie成功");
%>