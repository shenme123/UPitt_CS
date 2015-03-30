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

        <title>Login</title>
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

    <body>
        <!-- Container -->
        <div id="main">
            <h1>Login</h1>
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
                                    <label for="sf">Username</label>
                                    <input class="sf" name="username" type="text" value=""  />
                                </p>
                                <p>
                                    <label for="sf">Password</label>
                                    <input class="sf" name="password" type="text" value=""  />
                                </p>                          
                                <p>
                                    <input class="button" type="submit" value="Submit" />
                                    <input class="button" type="reset" value="Reset" />
                                </p>
                                <p>
                                    <label><a href="register_form.jsp">New User Register</a></label>
                                    <label><a href="project_form.jsp">New User Register</a></label>
                                    <label><a href="homepage.jsp">New User Register</a></label>
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
</html>
