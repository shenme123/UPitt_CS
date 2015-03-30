<%-- 
    Document   : header
    Created on : Nov 12, 2013, 8:51:50 AM
    Author     : jessica zhuang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*,action.*,util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>header</title>
		<link type="text/css" href="css/index.css" rel="stylesheet" />	
  </head>
	<%
	String username=(String)session.getAttribute("username");
        String f_name=(String)session.getAttribute("f_name");
	int uid=(Integer)session.getAttribute("uid");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	   
%>  
	<body>
	
<div id="container">
  <div id="header">
    <div id="top">
	<div class="logo"> 
		<img src="assets/logo.png" /> 
	</div>

	<div class="meta">
	<p>Welcome,<%=f_name %>!</p>
		<ul>
		<li><a  href=""  title="QUIT" class="tooltip" onClick="parent.location.href='login.jsp';"><span class="ui-icon ui-icon-power"></span>QUIT</a></li>
		<!--<li><a href="" target="MainFrame" title="Manage my account" class="tooltip"><span class="ui-icon ui-icon-person"></span>Account Management</a></li>-->
		</ul>	
	</div>
    </div>
      </div>
   </div>
    </body>
     <%} %>  
</html>