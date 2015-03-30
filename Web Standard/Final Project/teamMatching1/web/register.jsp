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
 
<frameset rows="15%,*" border=0 frameSpacing=0 noresize="noresize" frameborder=no >

<frame  frameBorder=no noResize scrolling=no>

<frameset cols="280,*"  border=0 frameSpacing=0 noresize="noresize" frameborder=no >
<frame  scrolling="yes" />
<frame name=MainFrame src="reg.jsp" scrolling="yes" />
</frameset>

</frameset>
<noframes></noframes>

</html>