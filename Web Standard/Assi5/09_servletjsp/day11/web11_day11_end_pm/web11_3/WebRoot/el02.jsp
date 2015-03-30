<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" import="bean.*"%>
<html>
	<head></head>
	<body style="font-size:30px;">
		<%
			User user = new User();
			user.setUsername("zs");
			user.setAge(22);
			IdCard card = new IdCard();
			card.setCardNo("123");
			user.setCard(card);
			user.setInterest(new String[]{"fishing","cooking"});
			request.setAttribute("user", user);
			
			User user2 = new User();
			user2.setUsername("zs2");
			user2.setAge(22);
			session.setAttribute("user",user2);
		 %>
		 username:${sessionScope.user.username}
		 cardNo:${user.card.cardNo}
		 age:${user["age"]}<br/>
		 <%	
		 	request.setAttribute("propname","age");
		  %>
		 age:${user[propname]}<br/>
		 interest:${user.interest[0]}
		 
		 
		 
	</body>
</html>