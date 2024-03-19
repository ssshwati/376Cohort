<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Success</title>
</head>
<body>
	<%
	String name = (String) request.getAttribute("myname");
	%>
	<%=name%>
	<%
	List<String> list = new ArrayList<>();
	%>
	<%--request.getAttribute("myname")--%>
	<%=application.getAttribute("myname")%>
	<%=config.getInitParameter("myname")%>
	<h2>login success !</h2>
	<h2>
		Welcome
		<%=session.getAttribute("uname")%>
	</h2>
</body>
</html>