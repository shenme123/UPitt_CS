<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" import="java.util.*" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		1+1:${1+1}<br/>
		${"111" + "111" }<br/>
		${"abc" == "abc"}<br/>
		<%
			request.setAttribute("str1","abc");
		 %>
		${"abc" eq  str1}<br/>
		
		情况1："":<br/>
		${empty ""}<br/>
		情况2：空的集合<br/>
		<%
			List list = new ArrayList();
			list.add("a");
			request.setAttribute("list1",list);
		 %>
		 ${empty list1}
		情况3：值为null<br/>
		<%
			request.setAttribute("obj",null);
		 %>
		${empty obj}
		情况4：找不到对象<br/>
		${empty aaa}
		
		
		
	</body>
</html>