<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	User u  = null;
	if(session.getAttribute("data")!=null){
		u = (User)session.getAttribute("data");
	}
	else{
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>Welcome, <%=u.getName() %></h1>
	<h1>Your contact is, <%=u.getContact() %></h1>
	<h1>Your address id  <%=u.getAddress() %></h1>
	<h1>Your email is, <%=u.getEmail()%></h1>
	<h1>Your password is , <%=u.getPassword() %></h1>
</body>
</html>