<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*,action.*,util.*" %>
<jsp:useBean id="cb" scope="page" class="bean.CustomerBean"/>
<jsp:useBean id="ob" scope="page" class="bean.OrderBean"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��������</title>
    
	<link type="text/css" href="css/layout.css" rel="stylesheet" />	
	
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/easyTooltip.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="js/hoverIntent.js"></script>
		<script type="text/javascript" src="js/superfish.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
<script language="JavaScript">
function orderSelect(){

  searchMe=document.getElementById("searchMethod");
	if(searchMe.value=="1"){
  		document.getElementById("form1").action="action/OrderServlet?method=getOrderByName"; 
    	document.getElementById("form1").submit(); 
 	}
	 else if(searchMe.value=="2"){
 			document.getElementById("form1").action="action/OrderServlet?method=getOrderByStatus"; 
   			document.getElementById("form1").submit(); 
 		}
 		else{
  			alert("����û��ѡ�����");
 		}
 	return true;
}
function selectChange(event){
	var selValue=$(event).val();

	if(selValue==1){
		$("#orderStatus").hide();
		$("#orderName").show();
	}
	if(selValue==2){
		$("#orderStatus").show();
		$("#orderName").hide();
		}
	
}
$(document).ready(function(){
	$("#orderStatus").hide();
	$("#orderName").hide();
});
</script>
		<script language="JavaScript">
		var allRoom;
		allRoom=[<%List preRoomList= ob.getAllRoom();
		 for(int i=0;i<preRoomList.size();i++){
		 	List roomobj = (List) preRoomList.get(i); %>{"roomId": <%=roomobj.get(0)%>,"hid": <%=roomobj.get(1)%>,
		 		"rname":"<%=roomobj.get(2)%>","price":"<%=roomobj.get(3)%>"
		 		}	<%if(i<preRoomList.size()-1){%>, <%}}%>];
		 	
		 	
		function selectRoomId(event){
	    	var hid=$(event).val();
	    	var oselect=$("#roomSelect");
	    	var optionStr="<option value='0'>��ѡѡ���ͣ�</option>";;
	    	//alert(allOrder);
	    	for(k=0;k<allRoom.length;k++){
	    	  if(hid==allRoom[k].hid){
	    		optionStr+="<option value="+allRoom[k].roomId+">"+allRoom[k].rname+"</option>";
	    		}
	    	  }
	    	oselect.html(optionStr);
	    
		}
		
		function selectC(event){
	var selValue=$(event).val();

	if(selValue>=6){
		$("#per").val("���Ŷ���");
		$("#vol").show();
	}
	if(selValue<6){
		$("#per").val("���˶���");
		$("#vol").hide();
		}
	
}
$(document).ready(function(){
	$("#vol").hide();
	$("#per").hide();
});

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
        if(confirm("ȷ��ɾ��ѡ�ж�����Ϣ��"))
           {
           document.getElementById("form2").action="action/OrderServlet?method=delOrder"; 
           document.getElementById("form2").submit(); 
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
        if(confirm("ȷ���޸�ѡ�ж�����Ϣ��"))
           {
          document.getElementById("form2").action="action/OrderServlet?method=modRequire"; 
           document.getElementById("form2").submit(); 
          }
         }
		}
		</script>
  </head>
 <%
	String username=(String)session.getAttribute("username");
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
		&ldquo;<!-- Container -->
	
					<div id="main">
					<h1>��������</h1>
					<div class="pad20">
					
						<!-- Tabs -->
						<div id="tabs">
							<ul>
									<li><a href="#tabs-1">��������</a></li>
									<li><a href="#tabs-2">��Ӷ���</a></li>
							
							
							</ul>
							<!-- Second tab -->
								<div id="tabs-1">
                                <!-- Form -->
									
										<!-- Fieldset -->
										<fieldset>
											<!--<legend>This is a simple fieldset</legend> -->
                                            
                                            <div id="search">
                                          <p>  
					<form id="form1" name="form1" action="" method="POST">
					<select id="searchMethod" onchange="selectChange(this);">
					<option value="">������ʽ</option>
					<option value="1">���ݿͻ�����</option>
					<option value="2">���ݶ���״̬</option>
					</select>
						 <span id="orderName">
						 <%
						 int uid=(Integer)session.getAttribute("uid");
						List list5 = cb.getAllCustomer(uid);
						if (!list5.isEmpty()) { %>
							<select name="cid" >
								<option value=0>��ѡ��������Ŀͻ�����</option>
								<%for (int i = 0; i < list5.size(); i++) {
								List list6 = (List) list5.get(i);
								out.println("<option value="+list6.get(0).toString()+">"+list6.get(2).toString()+"</option>");
								}}%>	 				
							</select>
						 </span>
						 <span id="orderStatus">
						<select id="selectStatus" name="order_status">
							<option value="">ѡ�񶩵�״̬</option>
							<option value="Ԥ����">Ԥ����</option>
							<option value="�ѳɽ�">�ѳɽ�</option>
							<option value="��ȡ��">��ȡ��</option>
						</select>
						 </span>
						 <input type="button" value="" class="but" onClick="orderSelect()" />
                         </p>
					</form>
                    </div>
                    <div >
                    <form id="form2" name="form2" action="" method="post">
                   <table  class="fullwidth" cellpadding="0" cellspacing="0" border="0" position="absolute" top="0px">
                                    <thead>
											<tr>
												<td><input name="delAll" type="checkbox" class="checkall" />ȫѡ</td>
												<td>�Ƶ꣺</td>
												<td>����:��</td>
												<td>���ڣ�</td>
												<td>�ܼۣ�</td>
												<td>����״̬��</td>
											</tr>
										</thead>
											<%
											List list1=(List)request.getAttribute("list");
											if(list1!=null){
											for(int i = 0; i<list1.size(); i++){
												List list3 = (List)list1.get(i);
												for(int j=0;j<list3.size();j++){
												List list2=(List)list3.get(j);
											
										 %>
											<tr class="odd">
												<td><input name="rowId" type="checkbox" value="<%=list2.get(0) %>" /></td>
												<td><%=list2.get(1).toString() %></td>
												<td><%=list2.get(2).toString() %></td>
												<td><%=list2.get(3).toString() %></td>
												<td><%=list2.get(4).toString() %></td>
												<td><%=list2.get(5).toString() %></td>
											</tr>
										<%}}} %>
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
						
								<div id="tabs-2">
                                <!-- Form -->
									<form method="post" action="action/OrderServlet?method=addOrder">
										<!-- Fieldset -->
										<fieldset>
											<p>
											<%
											
											List list = cb.getAllCustomer(uid);
										if (!list.isEmpty()) { %>
											<label for="sf">�ͻ�����</label>
						                   <select name="cid" >
											<option value=0>��ѡ��������Ŀͻ�����</option>
											 <%for (int i = 0; i < list.size(); i++) {
												List list2 = (List) list.get(i);
												out.println("<option value="+list2.get(0).toString()+">"+list2.get(2).toString()+"</option>");
												}}%>	 				
											</select>
											</p>
											<p>
											<% List list3 = ob.getAllHotel();
										if (!list3.isEmpty()) { %>
												<label for="sf">�Ƶ�����: </label>
						                <select name="hid" onchange="selectRoomId(this)">
											<option value=0>��ѡ��Ƶ�����</option>
											 <%for (int i = 0; i < list3.size(); i++) {
												List list4 = (List) list3.get(i);
												out.println("<option value="+list4.get(0).toString()+">"+list4.get(1).toString()+"</option>");
												}}%>	 				
											</select>
											</p>
											<p>
												<label for="sf">����: </label>
						       <select id="roomSelect" name="roomId" >
						       <option value=0>��ѡѡ����</option>
						       </select>  
												
											</p>
                                            <p>
												<label for="sf">����ʱ��: </label>
						<input class="sf" name="odate" type="text" value="" onclick="SelectDate(this,'yyyy-MM-dd')"
														this.Txt_Date.Attributes["onclick"] ="SelectDate(this,'yyyy-MM-dd')";/>
												
											</p>
											<p>
											<label for="sf">��ס����: </label>
											<input class="sf" name="days" type="text" value="" />
											</p>
											<p>
												<label for="dropdown">��ס����: </label>
						<select name="rquan" id="rquan" style="WIDTH: 100px" onchange="selectC(this);">
															<option selected="selected" value="">-��ѡ��-</option>
															<option value="1">1��</option>
                                                            <option value="2">2��</option>
                                                            <option value="3">3��</option>
                                                            <option value="4">4��</option>
                                                            <option value="5">5��</option>
                                                            <option value="6">6��</option>
                                                            <option value="7">7��</option>
                                                            <option value="8">8��</option>
                                                            <option value="9">9��</option>
                                                            <option value="10">10��</option>
                                                      </select>      
												<span class="field_desc">�ͻ�Ԥ���ķ�������</span>
											</p>
											<input id="per" name="oType" type="hidden" value="">
											 <p id="vol"> 
                                            <label for="sf">���ڹ�˾: </label>
						                <input class="sf" name="ccompany" type="text" value="" />
						                <span class="field_desc">��ͻ���������</span>
						                
                                            </p>
                                            
                                            <p>
												<label for="sf">��ϵ�绰: </label>
						<input class="sf" name="contact" type="text" value="" />
												<span class="field_desc">�ͻ�����ϵ�绰</span>
											</p>
											<p>
											<label for="sf">����״̬: </label>
											<select name="order_status" id="order_status" style="WIDTH: 100px";>
															<option selected="selected" value="">-��ѡ��-</option>
															<option value="�ѳɽ�">�ѳɽ�</option>
                                                            <option value="Ԥ����">Ԥ����</option>
                                                            <option value="��ȡ��">��ȡ��</option>
                                                    </select>        
											</p>
                                            <p>
												<label for="sf">����Ҫ��: </label>
                                                <span class="field_desc">�ͻ��ĸ�������</span>
						                            <p><input type="checkbox" name="meal"/>�Ƿ���Ҫ�������</p>
													<p><input type="checkbox" name="internet" />�Ƿ�Ҫ���л�����</p>
												
											</p>
                                                                                       
                                            
											<p>
                                               <label for="memo">��ע��Ϣ: </label>
                                              <textarea name="oremark" cols="" rows=""></textarea>
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