<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mb.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <%
            Account acc = (Account)request.getAttribute("account");
        %>
        <h1>Welcome Back!</h1>
        UserID: <%=acc.getUserID() %><br/>
        Password: <%=acc.getPassword() %><br/>
        <br/>
        <form method="get" action="Logout">
            <input type="submit" value="Logout"/>
        </form>
    </body>
</html>
