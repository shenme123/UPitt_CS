<%-- 
    Document   : index
    Created on : Nov 8, 2013, 10:29:59 PM
    Author     : Rui Bi
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
    
    <link type="text/css" href="css/login.css" rel="stylesheet" />
    <script src="Scripts/jquery-1.10.2.js" type="text/javascript"></script>  
    <script src="Scripts/jquery.cookie.js" type="text/javascript"></script> 
		<title>Login</title>	
	<SCRIPT language=javascript>
        function checklogin() {
	if (document.form1.username.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\Please enter your username!");
		document.form1.username.focus();
	}
	else if (document.form1.password.value.replace(/\s+$|^\s+/g,"").length<=0) {
		alert("\Please enter your password");
		document.form1.password.focus();
	}
	
	else{
	     form1.submit();
	}
}
</SCRIPT>
<script type="text/javascript">  
    $(document).ready(function () {  
        if ($.cookie("rmbUser") == "true") {  
        $("#ck_rmbUser").attr("checked", true);  
        $("#username").val($.cookie("username"));  
        $("#password").val($.cookie("password"));  
        }  
    });  
  
    function Save() {  
        if ($("#ck_rmbUser").attr("checked")) {  
            var str_username = $("#username").val();  
            var str_password = $("#password").val();  
            $.cookie("rmbUser", "true", { expires: 7 });  
            $.cookie("username", str_username, { expires: 7 });  
            $.cookie("password", str_password, { expires: 7 });  
        }  
        else {  
            $.cookie("rmbUser", "false", { expire: -1 });  
            $.cookie("username", "", { expires: -1 });  
            $.cookie("password", "", { expires: -1 });  
        }  
    };  
</script> 
	</head>
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
		
		</TR>
	</TBODY>
 </TABLE>
                <p class="space">
			  <span><input type="checkbox" id="ck_rmbUser" />Remember me</span>
			  <span> &nbsp;&nbsp;&nbsp;</span>
               <span><a href="">Register</a></span>
                <input type=submit value="Login" class="login" onClick="Save()" />
                
			</p>
			</form>
		</div>
	</div>

	</body>
</html>
