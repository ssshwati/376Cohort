<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("myname")%>
	<%=application.getAttribute("myname")%>
	
	<h2>login page</h2>
	<form action='login' method='post'>
		Enter Username : <input type='text' name='uname' /><br> Enter
		Password : <input type='password' name='pwd' /><br> <input
			type='submit' value='signIn' />
	</form>
</body>
</html>