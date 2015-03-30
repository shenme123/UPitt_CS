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
<jsp:useBean id="code" scope="page" class="util.CheckCode" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <link type="text/css" href="css/login.css" rel="stylesheet" />
        <script src="Scripts/jquery-1.10.2.js" type="text/javascript"></script>  
        <script src="Scripts/jquery.cookie.js" type="text/javascript"></script> 
        <title>Login</title>	
        <SCRIPT language=javascript>
            function checklogin() {
                if (document.form1.username.value.replace(/\s+$|^\s+/g, "").length <= 0) {
                    alert("\Please enter your username!");
                    document.form1.username.focus();
                }
                else if (document.form1.password.value.replace(/\s+$|^\s+/g, "").length <= 0) {
                    alert("\Please enter your password");
                    document.form1.password.focus();
                }

                else {
                    form1.submit();
                }
            }
        </SCRIPT>
        
    </head>
    <%
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
        if (!message.trim().equals("")) {
            out.println("<script language='javascript'>");
            out.println("alert('" + message + "');");
            out.println("</script>");
        }
        request.removeAttribute("message");
        String vCode = code.getCheckCode();
    %>
    <body>
        <div id="container">
            <div class="logo">			
                <img src="assets/logo.png">
            </div>
            <div id="box">
                <form id=form1 name=form1 action="action/LoginServlet?method=userLogin" method=post>
                    <TABLE width="100%" border=0 >
                        <TBODY>
                            <TR>
                                <TD height=25 >Username:</TD>
                                <TD><INPUT class=input_new id=username style="WIDTH: 110px" size=15 type=text maxLength=10 name=username  >
                                </TD>
                                <TD height=25>Password:</TD>
                                <TD height=25><INPUT class=input_new id=password style="WIDTH: 110px" type=password size=15 maxLength=16 name=password ></TD>
                                <TD height=25>Verify Code:</TD>
                                <TD height=25><input type="hidden" name="yzm" value="<%=vCode%>"> <INPUT class=input_new id=checkcode size=5 maxlength="4" name=checkcode onKeyUp="this.value = this.value.replace(/\D/gi, '')"> <%=vCode%>
                                </TD>
                            </TR>
                        </TBODY>
                    </TABLE>
                    <p class="space">
                      
                        <span> &nbsp;&nbsp;&nbsp;</span>
                        <span><a href="register.jsp">Register</a></span>
                        <input type=submit value="Login" class="login" onClick="checklogin()" />

                    </p>
                </form>
            </div>
        </div>

    </body>
</html>
