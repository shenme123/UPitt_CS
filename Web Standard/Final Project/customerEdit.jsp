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
    
   <title>Ա������ �ͻ��鿴</title>
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
		<script language="javascript" type="text/javascript">
		function del(){
		var ck=document.getElementsByName("rowId");
		 var cid=0;
		  for(i=0;i<ck.length;i++){
        if(ck[i].checked){
           cid++;
        	}
       		}
         if(cid==0)
        {
         alert("����ѡ��һ��!");
         return;
        }
          else
        {
        if(confirm("ȷ��ɾ��ѡ�пͻ���Ϣ��"))
           {
           document.getElementById("form1").action="action/CustomerServlet?method=delCustomer"; 
           document.getElementById("form1").submit(); 
          }
        }
          }
		
		function modify(){
		var ck=document.getElementsByName("rowId");
		var cid=0;
		  for(i=0;i<ck.length;i++){
        if(ck[i].checked){
           cid++;
        	}
        
        }
         if(cid==0)
        {
         alert("����ѡ��һ��!");
         return;
        }
          else
        {
        if(confirm("ȷ���޸�ѡ�пͻ���Ϣ��"))
           {
          document.getElementById("form1").action="action/CustomerServlet?method=modRequire"; 
           document.getElementById("form1").submit(); 
          }
         }
		}
		
		function selectToShow(){
	   		$("#detail").toggle();}
	   	$(document).ready(function(){
			$("#detail").hide();})
		</script>
		
		
		<!-- End of Libraries -->	
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
					<h1>�ͻ�����</h1>
					<div class="pad20">
					
						<!-- Tabs -->
						<div id="tabs">
							<ul>
									<li><a href="#tabs-1">����ĳ���ͻ�</a></li>
								<li><a href="#tabs-2">�鿴���пͻ��б�</a></li>
							    <li><a href="#tabs-3">��ӿͻ�</a></li>
							
							</ul>
							<!-- Second tab -->
								<div id="tabs-1">
                                <!-- Form -->
									
										<!-- Fieldset -->
										<fieldset>
											<!--<legend>This is a simple fieldset</legend> -->
                                            
                                            <div id="search">
                                          <p>  
					<form action="action/CustomerServlet?method=getCustomer" method="POST">
						 <input type="text" name="cname" value="�������û���ʵ����:" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" />
						 <input type="submit" value="" class="but"  />
                         </p>
					</form>
                    </div>
                    <div >
                    <form action="" method="post">
                   <table  class="fullwidth" cellpadding="0" cellspacing="0" border="0" position="absolute" top="0px">
                                    <thead>
											<tr>
												<td><input name="delAll" type="checkbox" class="checkall" />ȫѡ</td>
												<td>�ͻ�������</td>
												<td>�Ա�</td>
												<td>�������䣺</td>
												<td>��ϵ�绰��</td>
												
											</tr>
										</thead>
											<%
											List list3=null;
											list3=(List)request.getAttribute("list");
										if(list3!=null){
										 for(int i = 0; i<list3.size(); i++){
											List list2 = (List)list3.get(i);
										
										 %>
											<tr class="odd" onClick="selectToShow()">
												<td><input name="rowId" type="checkbox" value="<%=list2.get(0) %>" /></td>
												<td><%=list2.get(1).toString() %></td>
												<td><%=list2.get(2).toString() %></td>
												<td><%=list2.get(9).toString() %></td>
												<td><%=list2.get(7).toString() %></td>
												
											</tr>
											
										<%}} %>
										<tr>
										<td>
										<input type="submit" value="ɾ����ѡ��Ŀ" class="but" onClick="del()" />
										</td>
										<td>
										<input type="submit" value="�޸���ѡ��Ŀ" class="but" onClick="modify()" />
										</td>
										</tr>
                                  
                             </table>
                             ��                                            </form>
                    </div>
										</fieldset>
										<!-- End of fieldset -->
									
                                </div>
						
							<div id="tabs-2" >
									<fieldset>
									<form id="form1" name="form1" action="" method="post">
                                    <table class="fullwidth" cellpadding="0" cellspacing="0" border="0" height="500px">
                                    
										<thead>
											<tr>
												<td><input name="delAll" type="checkbox" class="checkall" />ȫѡ</td>
												<td>�ͻ�������</td>
												<td>�Ա�</td>
												<td>�������䣺</td>
												<td>��ϵ�绰��</td>
												
											</tr>
										</thead>
										<tbody>
										<%
										
										List list1=cb.getAllCustomer(uid);
										if(list1!=null){
										 for(int i = 0; i<list1.size(); i++){
											List list2 = (List)list1.get(i);
										
										 %>
											<tr class="odd">
												<td><input name="rowId" type="checkbox" value="<%=list2.get(0) %>" /></td>
												<td><%=list2.get(2).toString() %></td>
												<td><%=list2.get(3).toString() %></td>
												<td><%=list2.get(10).toString() %></td>
												<td><%=list2.get(8).toString() %></td>
												
											</tr>
										<%}} %>
										<tr class="odd">
											 <td>
											<input type="button" value="ɾ����ѡ��Ŀ" class="but" onClick="del()" />
											</td>
											<td>
										<input type="button" value="�޸���ѡ��Ŀ" class="but" onClick="modify()" />
										</td>
										</tr>
										</tbody>
										
									</table>
									</form>
                                    </fieldset>								<!-- End of Form -->	
								</div>
								<div id="tabs-3">
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
                
				<!-- End of Main Content -->
				
	</body>
	<%} %>
</html>