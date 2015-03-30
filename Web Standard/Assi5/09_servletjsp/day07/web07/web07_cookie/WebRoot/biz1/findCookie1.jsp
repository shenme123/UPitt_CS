<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%
	Cookie[] cookies = 
	request.getCookies();
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			Cookie curr = cookies[i];
			out.println(
			curr.getName() + " " 
			+ curr.getValue()+"<br/>");
		}
	}else{
		out.println("没有cookie");
	}
%>