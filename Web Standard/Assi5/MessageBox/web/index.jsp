<%-- 
    Document   : index
    Created on : 2011-11-5, 15:56:11
    Author     : Administrator
--%>

<%@page import="MB.ClickNumBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- java bean scoped in application so it is share by every visitors, can be used to caculate the click number -->
<jsp:useBean id="Online" class="MB.ClickNumBean" scope="application" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body style="text-align: center">
        <h1>MessegeBox Login</h1>
        <form method="Post" action="getInfo?act=view&page=1">
            <!-- give different page according to UserName session value -->
            <%
            if(request.getSession().getAttribute("UserName")==null){
            %>
            Your name<input type="text" name="UserName" value="" />
            <input type="submit" value="Login" />
            <%
            }else{
            %>
            Your name is <%=request.getSession().getAttribute("UserName") %> <a href="getInfo?page=1&act=view">Enter</a><br />
            <a href="Logout" >Logout</a>
            <% 
            }
            %>
        </form>
            <!-- get the click number -->
            <br />There are <%=Online.getVisitNum()%> clicks in this page.
            <br /><a href="getDescription" target="_blank">Description</a>
    </body>
</html>
