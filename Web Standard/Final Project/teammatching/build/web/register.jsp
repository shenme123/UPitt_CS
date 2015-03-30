<%-- 
    Document   : index
    Created on : Nov 8, 2013, 10:29:59 PM
    Author     : Rui Bi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*,action.*,util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:useBean id="ub" scope="page" class="bean.UserBean"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <link type="text/css" href="css/login.css" rel="stylesheet" />

        <SCRIPT language=JavaScript src="js/index.js"></SCRIPT>
         <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
       <script language="JavaScript">
		var tag=[<%List preTagList= ub.getTagInfo();
		    for(int i=0;i<preTagList.size();i++){
		 	List tagObj = (List) preTagList.get(i); %>
			{"id":"<%=tagObj.get(0)%>","tid": "<%=tagObj.get(0)%>","tagName": "<%=tagObj.get(1)%>"}	
			<%if(i<preTagList.size()-1){%>, <%}}%>];
		var tidSelected_1;
		
        function selectChange_1(event){
						
	    	tidSelected_1=$(event).val();
	    	
	    	var optionStr="<option value='0'>-Please Choose the First Your Interest-</option>";
	    	
	    	for(k=0;k<tag.length;k++){
			if(tag[k].tid!=tidSelected_1){
					
			optionStr+="<option value="+tag[k].tid+">"+tag[k].tagName+"</option>";
	    	   }    	  
	    	}
	    	$("#techTag2").html(optionStr);
			
			
	    }
			
		function selectChange_2(event){			
	    	var tidSelected_2=$(event).val();
	    	var optionStr="<option value='0'>-Please Choose the First Your Interest-</option>";
	    	
	    	for(k=0;k<tag.length;k++){
	    	 if(tag[k].tid!=tidSelected_2){
					if(tag[k].tid!=tidSelected_1){
			optionStr+="<option value="+tag[k].tid+">"+tag[k].tagName+"</option>";
					}
	    	   }    	
	    	}
	    	$("#techTag3").html(optionStr);
	    }
		function verify(){
                var pwd_1=$("#pwd_1").val();
                var pwd_2=$("#pwd_2").val();
                
                if(pwd_1!=pwd_2){
                    alert("Entered Passwords Differ!");
                }
            }
        
        </script>
        <title>Login</title>	

    </head>

    <body>
        <div id="container">
            <div class="logo">			
                <img src="assets/logo.png">
            </div>
            <div id="box">
                <h1>User Register:</h1>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <form id="form1" name="form1" method="post" action="action/LoginServlet?method=register">
                    <p> <label for="sf">Username:</label>
                        <input class="sf" name="username" type="text" value="" /> </p>

                    <p> <label for ="sf">Password:</label>
                        <input class="sf" id="pwd_1" name="password" type="password" value=""  /> </p>
                    <p> <label for="sf">Password Verify:</label>
                        <input class="sf" id="pwd_2"  type="password" value=""  onblur="verify()"/> </p>
                    <p> <label for="sf">First Name:</label>
                        <input class="sf" name="f_name" type="text" value=""  /> </p>
                    <p> <label for="sf">Last Name:</label>
                        <input class="sf" name="l_name" type="text" value=""  /> </p>
                    <p> <label for="sf">Gender:</label>
                        <input type="radio" name="gender" value="M" checked="checked">Male 
                        <input type="radio" name="gender" value="F">Female </p>
                    <p>	<% List list3 = ub.getTagInfo();
                        if (!list3.isEmpty()) { %>
                        <label for="sf">Tech Interest 1: </label>
		<select name="tag_1" id="techTag1" style="WIDTH: 250px"  onchange="selectChange_1(this)">
             <option selected="selected" value="">-Please Choose the First Your Interest-</option>
		<%for (int i = 0; i < list3.size(); i++) {List list4 = (List) list3.get(i);
              out.println("<option value="+list4.get(0).toString()+">"+list4.get(1).toString()+"</option>");}}%></select>
                     <span class="field_desc">Choose one of technologies you handle best</span></p>
                   
              <p><label for="sf">Tech Interest 2: </label>
		<select name="tag_2" id="techTag2" style="WIDTH: 250px" onchange="selectChange_2(this)">
                <option selected="selected" value="">-Please Choose the Second Your Interest-</option>
		 </select>
                  <span class="field_desc">Choose your handle second best technology</span>
              </p>
         
             <p><label for="sf">Tech Interest 3: </label>
		<select name="tag_3" id="techTag3" style="WIDTH: 250px">
			<option selected="selected" value="">-Please Choose the Third Your Interest-</option>
		  </select> 
             <span class="field_desc">Choose the last technology you handle also well</span>
             </p>



                    <input class="button" type="submit" value="Submit" />
                    <input class="button" type="reset" value="Reset" />
                    </p>                 

                </form>
            </div>
        </div>

    </body>
</html>
