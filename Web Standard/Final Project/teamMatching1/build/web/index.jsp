<%-- 
    Document   : frame
    Created on : Nov 12, 2013, 8:47:32 AM
    Author     :Rui Bi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*,action.*,util.*" %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Index</title>

  </head>
  
<%
	String username=(String)session.getAttribute("username");
	int uid=(Integer)session.getAttribute("uid");
	String position=(String)session.getAttribute("position");
         String advisor=(String)session.getAttribute("advisor");

	
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	   
%>
<frameset rows="15%,*" border=0 frameSpacing=0 noresize="noresize" frameborder=no >

<frame src="header.jsp" frameBorder=no noResize scrolling=no>

<frameset cols="280,*"  border=0 frameSpacing=0 noresize="noresize" frameborder=no >
<frame src="menu.jsp" scrolling="yes" />
<frame name=MainFrame src="main.jsp" scrolling="yes" />
</frameset>

</frameset>
<noframes></noframes>
 <%} %>
</html>