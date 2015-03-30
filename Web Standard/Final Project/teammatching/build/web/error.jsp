<%-- 
    Document   : index
    Created on : Nov 8, 2013, 10:29:59 PM
    Author     : Rui Bi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page import="java.util.*,action.*,util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <link type="text/css" href="css/login.css" rel="stylesheet" />
        <script src="Scripts/jquery-1.10.2.js" type="text/javascript"></script>  
     
        <title>Oops!Error!</title>	

    </head>
    <body>
        <div id="container">
            <div class="logo">			
                <img src="assets/logo.png">
            </div>
            <div id="box">
                <h1>Oops!The error occurred!</h1>
            </div>
        </div>

    </body>
</html>


