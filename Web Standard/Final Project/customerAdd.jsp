<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*,action.*,util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Ա������ �ͻ����</title>
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
	String username=(String)session.getAttribute("username");
	int uid=(Integer)session.getAttribute("uid");
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
					<h1>��ӿͻ�</h1>
					<div class="pad20">
					
						<!-- Tabs -->
						<div id="tabs">
							<ul>
								<li><a href="#tabs-1">���</a></li>
							</ul>
							
							
								<!-- Second tab -->
								<div id="tabs-1">
                                <!-- Form -->
									<form method="post" action="action/CustomerServlet?method=addCustomer">
										<!-- Fieldset -->
										<fieldset>
											<!--<legend>This is a simple fieldset</legend> -->
											<p>
												<label for="sf">�ͻ�����: </label>
						    <input class="sf" name="cname" type="text" value=""  />
												
											</p>
                                              <p>
												<label for="sf">�Ա�: </label>
												<input type="radio"name="csex" value="��" checked="checked"> �� 
                                                <input type="radio" name="csex" value="Ů">Ů
											</p>
                                            <p>
												<label for="sf">����: </label>
						<input class="sf" name="cbirth" type="text" value=""onclick="SelectDate(this,'yyyy-MM-dd')"
														this.Txt_Date.Attributes["onclick"] ="SelectDate(this,'yyyy-MM-dd')"; />
											
											</p>
                                            <p>
												<label for="sf">���֤����: </label>
						<input class="sf" name="IDcard" type="text" value="" />
												
											</p>
											<p>
												<label for="sf">�ͻ�ְҵ: </label>
						<input class="sf" name="cjob" type="text" value="" />
												
											</p>
                                          
                                            <p>
												<label for="sf">���ڳ���: </label>
						<input class="sf" name="ccity" type="text" value="" />
												
											</p>
                                            <p>
												<label for="sf">��ϵ�绰: </label>
						<input class="sf" name="ctel" type="text" value="" />
												
											</p>
                                            <p>
												<label for="sf">�ƶ��绰: </label>
						<input class="sf" name="cphone" type="text" value="" />
												
											</p>
                                            <p>
												<label for="sf">����: </label>
						<input class="sf" name="cmail" type="text" value="" />
												
											</p>
											<p>
												<label for="sf">�ػ�����: </label>
                                                
						                            <p><input type="checkbox" name="birth_warm"/>��������</p>
													<p><input type="checkbox" name="mail_sub" />�ʼ�����</p>
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
	<%} %>
</html>
