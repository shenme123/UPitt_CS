<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		<%
			pageContext.setAttribute("address","beijing");
		 %>
		 address:<%=pageContext.getAttribute("address")%>
		 <a href="jsp06.jsp">jsp06</a>
	</body>
</html>