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
    
    <title>订单管理</title>
    
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
  			alert("您还没有选择类别！");
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
	    	var optionStr="<option value='0'>请选选择房型：</option>";;
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
		$("#per").val("集团订单");
		$("#vol").show();
	}
	if(selValue<6){
		$("#per").val("个人订单");
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
         alert("最少选择一项!");
         return;
        }
          else
        {
        if(confirm("确认删除选中订单信息？"))
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
         alert("最少选择一项!");
         return;
        }
          else
        {
        if(confirm("确认修改选中订单信息？"))
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
					<h1>订单管理</h1>
					<div class="pad20">
					
						<!-- Tabs -->
						<div id="tabs">
							<ul>
									<li><a href="#tabs-1">搜索订单</a></li>
									<li><a href="#tabs-2">添加订单</a></li>
							
							
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
					<option value="">搜索方式</option>
					<option value="1">根据客户姓名</option>
					<option value="2">根据订单状态</option>
					</select>
						 <span id="orderName">
						 <%
						 int uid=(Integer)session.getAttribute("uid");
						List list5 = cb.getAllCustomer(uid);
						if (!list5.isEmpty()) { %>
							<select name="cid" >
								<option value=0>请选择所负责的客户姓名</option>
								<%for (int i = 0; i < list5.size(); i++) {
								List list6 = (List) list5.get(i);
								out.println("<option value="+list6.get(0).toString()+">"+list6.get(2).toString()+"</option>");
								}}%>	 				
							</select>
						 </span>
						 <span id="orderStatus">
						<select id="selectStatus" name="order_status">
							<option value="">选择订单状态</option>
							<option value="预订中">预订中</option>
							<option value="已成交">已成交</option>
							<option value="已取消">已取消</option>
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
												<td><input name="delAll" type="checkbox" class="checkall" />全选</td>
												<td>酒店：</td>
												<td>房型:：</td>
												<td>日期：</td>
												<td>总价：</td>
												<td>订单状态：</td>
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
										<input type="submit" value="删除所选项目" class="but" onClick="del()" />
										</td>
										<td>
										<input type="submit" value="修改所选项目" class="but" onClick="modify()" />
										</td>
										</tr>
                                  
                             </table>
                             、                                            </form>
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
											<label for="sf">客户姓名</label>
						                   <select name="cid" >
											<option value=0>请选择所负责的客户姓名</option>
											 <%for (int i = 0; i < list.size(); i++) {
												List list2 = (List) list.get(i);
												out.println("<option value="+list2.get(0).toString()+">"+list2.get(2).toString()+"</option>");
												}}%>	 				
											</select>
											</p>
											<p>
											<% List list3 = ob.getAllHotel();
										if (!list3.isEmpty()) { %>
												<label for="sf">酒店名称: </label>
						                <select name="hid" onchange="selectRoomId(this)">
											<option value=0>请选择酒店名称</option>
											 <%for (int i = 0; i < list3.size(); i++) {
												List list4 = (List) list3.get(i);
												out.println("<option value="+list4.get(0).toString()+">"+list4.get(1).toString()+"</option>");
												}}%>	 				
											</select>
											</p>
											<p>
												<label for="sf">房型: </label>
						       <select id="roomSelect" name="roomId" >
						       <option value=0>请选选择房型</option>
						       </select>  
												
											</p>
                                            <p>
												<label for="sf">订单时间: </label>
						<input class="sf" name="odate" type="text" value="" onclick="SelectDate(this,'yyyy-MM-dd')"
														this.Txt_Date.Attributes["onclick"] ="SelectDate(this,'yyyy-MM-dd')";/>
												
											</p>
											<p>
											<label for="sf">入住天数: </label>
											<input class="sf" name="days" type="text" value="" />
											</p>
											<p>
												<label for="dropdown">入住房数: </label>
						<select name="rquan" id="rquan" style="WIDTH: 100px" onchange="selectC(this);">
															<option selected="selected" value="">-请选择-</option>
															<option value="1">1间</option>
                                                            <option value="2">2间</option>
                                                            <option value="3">3间</option>
                                                            <option value="4">4间</option>
                                                            <option value="5">5间</option>
                                                            <option value="6">6间</option>
                                                            <option value="7">7间</option>
                                                            <option value="8">8间</option>
                                                            <option value="9">9间</option>
                                                            <option value="10">10间</option>
                                                      </select>      
												<span class="field_desc">客户预订的房间数量</span>
											</p>
											<input id="per" name="oType" type="hidden" value="">
											 <p id="vol"> 
                                            <label for="sf">所在公司: </label>
						                <input class="sf" name="ccompany" type="text" value="" />
						                <span class="field_desc">大客户类型需填</span>
						                
                                            </p>
                                            
                                            <p>
												<label for="sf">联系电话: </label>
						<input class="sf" name="contact" type="text" value="" />
												<span class="field_desc">客户的联系电话</span>
											</p>
											<p>
											<label for="sf">订单状态: </label>
											<select name="order_status" id="order_status" style="WIDTH: 100px";>
															<option selected="selected" value="">-请选择-</option>
															<option value="已成交">已成交</option>
                                                            <option value="预订中">预定中</option>
                                                            <option value="已取消">已取消</option>
                                                    </select>        
											</p>
                                            <p>
												<label for="sf">附加要求: </label>
                                                <span class="field_desc">客户的附加需求</span>
						                            <p><input type="checkbox" name="meal"/>是否需要包含早餐</p>
													<p><input type="checkbox" name="internet" />是否要求有互联网</p>
												
											</p>
                                                                                       
                                            
											<p>
                                               <label for="memo">备注信息: </label>
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