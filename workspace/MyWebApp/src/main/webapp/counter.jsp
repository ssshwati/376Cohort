<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<%-- counter implemented in jsp --%>
	<%!int count = 0;
	List<String> list = new ArrayList<>();
	public String sayHello(String name) {
		return "welcome " + name + " ";
	}
	%>
	<%
	count++;
	%>

	<h2>
	<%= sayHello("shwati") %>
		you are visitor number
		<%=count%></h2>
</body>
</html>