<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>Register</title>
        <!-- End of Page title -->

        <!-- Libraries -->
        <link type="text/css" href="css/layout.css" rel="stylesheet" />	

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/easyTooltip.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
        <script type="text/javascript" src="js/hoverIntent.js"></script>
        <script type="text/javascript" src="js/superfish.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <SCRIPT language=JavaScript src="js/calendar.js"></SCRIPT>
        <!-- End of Libraries -->	
    </head>
    <%
        String username = (String) session.getAttribute("username");
        int uid = (Integer) session.getAttribute("uid");
        String sname = (String) session.getAttribute("sname");
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
        if (username == null) {
 //           response.sendRedirect(path + "/error.jsp");
 //     } else {
    %>  

    <body>
        <!-- Container -->

        <div id="main">
            <h1>Registration Form</h1>
            <div class="pad20">

                <!-- Tabs -->
                <div id="tabs">
                    <!-- Second tab -->
                    <div id="tabs-1">
                        <!-- Form -->
                        <form method="post" action="action/CustomerServlet?method=addCustomer">
                            <!-- Fieldset -->
                            <fieldset>
                                <!--<legend>This is a simple fieldset</legend> -->
                                <p>
                                    <label for="sf">Username </label>
                                    <input class="sf" name="username" type="text" value=""  />
                                </p>
                                <p>
                                    <label for="sf">Password</label>
                                    <input class="sf" name="password" type="text" value=""  />
                                </p>
                                <p>
                                    <label for="sf">First Name </label>
                                    <input class="sf" name="fname" type="text" value=""  />
                                </p>
                                <p>
                                    <label for="sf">Last Name </label>
                                    <input class="sf" name="lname" type="text" value=""  />
                                </p>
                                <p>
                                    <label for="sf">Gender</label>
                                    <input type="radio" name="csex" value="male" checked="checked"> Male
                                    <input type="radio" name="csex" value="female"> Female
                                </p>

                                <p>
                                    <label for="sf">Pitt ID</label>
                                    <input class="sf" name="ID" type="text" value="" />

                                </p>
                                <p>
                                    <label for="sf">Email </label>
                                    <input class="sf" name="email" type="text" value="" />
                                </p>
                                <p>
                                    <label for="dropdown">Course 1</label>
                                    <select name="c1" id="c1" style="WIDTH: 100px" onchange="selectChange(this);">
                                        <option selected="selected" value="">select</option>
                                        <option value="1">2000</option>
                                        <option value="2">2001</option>
                                        <option value="3">2002</option>
                                        <option value="4">2003</option>
                                        <option value="5">2004</option>
                                        <option value="6">2005</option>
                                    </select>      
                                </p>
                                                                <p>
                                    <label for="dropdown">Course 2</label>
                                    <select name="c1" id="c2" style="WIDTH: 100px" onchange="selectChange(this);">
                                        <option selected="selected" value="">select</option>
                                        <option value="1">2000</option>
                                        <option value="2">2001</option>
                                        <option value="3">2002</option>
                                        <option value="4">2003</option>
                                        <option value="5">2004</option>
                                        <option value="6">2005</option>
                                    </select>      
                                </p>
                                <p>
                                    <label for="dropdown">Course 3</label>
                                    <select name="c1" id="c3" style="WIDTH: 100px" onchange="selectChange(this);">
                                        <option selected="selected" value="">select</option>
                                        <option value="1">2000</option>
                                        <option value="2">2001</option>
                                        <option value="3">2002</option>
                                        <option value="4">2003</option>
                                        <option value="5">2004</option>
                                        <option value="6">2005</option>
                                    </select>      
                                </p>
                                <p>
                                    <input class="button" type="submit" value="Submit" />
                                    <input class="button" type="reset" value="Reset" />
                                </p>
                            </fieldset>
                            <!-- End of fieldset -->
                        </form>
                    </div>
                    <!-- End of Tabs -->
                </div>


            </div>
        </div>


    </body>
    <%}%>
</html>
