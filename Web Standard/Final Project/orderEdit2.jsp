<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="cb" scope="page" class="bean.CustomerBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*,action.*,util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸Ŀͻ���Ϣ</title>
   <link type="text/css" href="css/layout.css" rel="stylesheet" />	
		
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/easyTooltip.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="js/hoverIntent.js"></script>
		<script type="text/javascript" src="js/superfish.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>

  </head>
 <%
	String username=(String)session.getAttribute("username");
	int uid=0;
	uid=(Integer)session.getAttribute("uid");
	String sname=(String)session.getAttribute("sname");
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
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
	   
%>  
	<body>
		<!-- Container -->
	
					<div id="main">
					<h1>�鿴�ͻ�</h1>
					<div class="pad20">
					
						<!-- Tabs -->
						<div id="tabs">
							<ul>
									<li><a href="#tabs-1">�޸Ŀͻ�</a></li>
								
							
							
							</ul>
							<!-- Second tab -->
								
						
							<div id="tabs-1" >
									<fieldset>
									<form id="form1" name="form1" action="action/OrderServlet?method=upOrder" method="post">
                                    <table class="fullwidth" cellpadding="0" cellspacing="0" border="0" height="500px">
                             			<tbody>
										<%
										List list1=(List)request.getAttribute("list");
										if(list1!=null){
										 for(int i = 0; i<list1.size(); i++){
											List list3 = (List)list1.get(i);
											for(int j=0;j<list3.size();j++){
											List list2=(List)list3.get(j);
										
										 %>
										 <tr class="odd">
										 <td >������Ϣ��</td>
												<td>�������ڣ�</td>
												<td>�Ƶ����ƣ�</td>
												<td>�ͷ����ͣ�</td>
												<td>��ס������</td>
												
										 </tr>
											
											<tr >
											<td><input type="hidden" name="oid" value="<%=list2.get(0).toString()%>"/></td>
											<td><input class="sf" name="odate" type="text" value="<%=list2.get(3).toString() %>" onclick="SelectDate(this,'yyyy-MM-dd')"
														this.Txt_Date.Attributes["onclick"] ="SelectDate(this,'yyyy-MM-dd')"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" />
											</td>
											<td><input class="sf" name="hname" type="text" value="<%=list2.get(1).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" /></td>
											<td><input class="sf" name="rname" type="text" value="<%=list2.get(2).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" /></td>
											<td><input class="sf" name="day" type="text" value="<%=list2.get(4).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											
											</tr>
											<tr class="odd">
										 <td >�������ͣ�</td>
												
												<td>��ϵ�绰��</td>
												<td>������</td>
												<td>�ɽ���</td>
												<td>��ס������</td>
										 </tr>
											<tr>
											<td><input class="sf" name="oType" type="text" value="<%=list2.get(8).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											<td><input class="sf" name="contact" type="text" value="<%=list2.get(5).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											<td><input class="sf" name="sumPrice" type="text" value="<%=list2.get(6).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											<td><input class="sf" name="order_status" type="text" value="<%=list2.get(7).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											<td><input class="sf" name="rquan" type="text" value="<%=list2.get(9).toString() %>"  onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></td>
											</tr>	
										<%}}} %>
										<tr class="odd">
											 <td></td>
											 <td></td>
											 <td></td>
											 <td></td>
											<td>
										<input type="submit" value="�ύ�޸���Ŀ" class="but"  />
										</td>
									
										</tr>
										</tbody>
										
									</table>
									</form>
                                    </fieldset>								<!-- End of Form -->	
								</div>
								
								
								
                                							<!-- End of Tabs -->
						</div>
						
						
					</div>
				</div>
                
				<!-- End of Main Content -->
				
	</body>
	<%} %>
</html>