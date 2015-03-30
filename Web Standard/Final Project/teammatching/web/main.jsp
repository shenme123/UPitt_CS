<%-- 
    Document   : main
    Created on : Nov 11, 2013, 9:42:47 AM
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
<jsp:useBean id="pb" scope="page" class="bean.ProjectBean"/>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>Main</title>
        <link type="text/css" href="css/layout.css" rel="stylesheet" />

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/easyTooltip.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
        <script type="text/javascript" src="js/hoverIntent.js"></script>
        <script type="text/javascript" src="js/superfish.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <SCRIPT language=JavaScript src="js/calendar.js"></SCRIPT>

        <script language="javascript" type="text/javascript">
            $(function() {
                $("button").click(function() {
                    var id = $(this).val();
                    var detail = [<%List pInfo = pb.getProposal();
            for (int i = 0; i < pInfo.size(); i++) {
                        List pObj = (List) pInfo.get(i);%>
                    {"id":"<%=pObj.get(0).toString()%>", "proposal": "<%=pObj.get(1).toString().trim()%>"}
            <%if (i < pInfo.size() - 1) {%>, <%}
                                    }%>
        ];
                            var str = "<p></p>";
                    for (k = 0; k < detail.length; k++) {
                        if (detail[k].id == id) {
                            str += "<p>" + detail[k].proposal + "</p>";
                        }
                    }

                    $("#preview").html(str);

                    $("#p_shadow").css('display', 'block');
                    $("#p_popbox").fadeIn('slow');

                });
                $("#close").click(function() {
                    $("#p_shadow").css('display', 'none');
                    $("#p_popbox").fadeOut('fast');
                });
            })
        </script>
    </head>
    <%
        String username = (String) session.getAttribute("username");
        String f_name = (String) session.getAttribute("f_name");
        int uid = (Integer) session.getAttribute("uid");
        String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
        if (username == null) {
            response.sendRedirect(path + "/error.jsp");
        } else {

    %>  
    <body>
        <div id="main">
            <h1>Welcome, <%=f_name%>!</h1>
            <div class="pad20">

                <div id="tabs">
                    <ul>
                        <li><a href="#tabs-1">Project Idea Recommendation</a></li>
                        <li><a href="#tabs-2">Post Your Idea</a></li>
                    </ul>
                    <div id="tabs-1">
                        <table  class="fullwidth" cellpadding="0" cellspacing="0" border="0" >
                            <thead>
                                <tr>
                                     <td>Ranking:</td>
                                    <td>Project Name:</td>
                                    <td>Team Size:</td>
                                    <td>Issue Date:</td>
                                    <td>Expire Date</td>
                                    <td>Issue By:</td>
                                    
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <%List list1 = pb.getProject(uid);
                                    if (list1 != null) {
                                        for (int row = 0; row < list1.size(); row++) {
                                            List list2 = (List) list1.get(row);
                                            
                                %>
                                <tr class="odd">
                                    <td>#&nbsp;&nbsp;<%=row+1%></td>
                                    <td><%=list2.get(1).toString()%></td>
                                    <td><%=list2.get(2).toString()%></td>
                                    <td><%=list2.get(3).toString()%></td>
                                    <td><%=list2.get(4).toString()%></td>
                                    <td><%=list2.get(5).toString()%></td>
                                   
                                    <td> <button  title="Preview" value="<%=list2.get(0).toString()%>" >Preview</button></td>
                                </tr>
                                <%}
                            }%>  

                            </tbody>
                        </table>
                        <div class="shadow" id="p_shadow"></div>
                        <div class="popbox" id="p_popbox">
                            <h1><a href="javascript:void(0);" id="close" title="Close">-</a></h1>
                            <div id="preview"></div>
                        </div>                         
                    </div>

                    <div id="tabs-2">

                        <form method="post" action="action/ProjectServlet?method=ideaPost">
                            <p> <label for="sf">Project Name:</label>
                                <input class="sf" name="pname" type="text" value=""  /> </p>

                            <p><label for="sf">Expire Date: </label>
                                <input class="sf" name="p_edate" type="text" value="" />
                            <span class="field_desc">(Format like: YYYY-MM-DD)</span>
                            </p>

                            <p><label for="sf">Team Size: </label>
                                <select name="teamsize" id="teamsize" style="WIDTH: 250px" onchange="selectChange(this);">
                                    <option selected="selected" value="">-Please Choose the Number of People-</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select> </p>
                            <p> <label for="memo">Proposal: </label>
                                <textarea name="proposal" cols="" rows=""></textarea></p>
                            <p>
                                <input class="button" type="submit" value="Submit" />
                                <input class="button" type="reset" value="Reset" />
                            </p>                 
                            <input type="hidden" name="username" value="<%=f_name%>"/> 
                            <input type="hidden" name="uid" value="<%=uid%>"/> 
                        </form>
                    </div>
                    <!-- End of Tabs -->
                </div>
            </div>
        </div>

    </body>
    <%}%>  
</html>
