<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input {
	display: block;
}
</style>
</head>
<body>

	<form action="savestud.htm" method="post">
	    <label for="name">Enter name:</label>
	    <input type="text" id="name" name="name" required><br>
	
	    <label for="age">Enter age:</label>
	    <input type="number" id="age" name="age" required><br>
	
	    <label for="mobileNo">Enter Mobile No:</label>
	    <input type="tel" id="mobileNo" name="mobileNo" required><br>
	    
	    <label for="email">Enter Email:</label>  <br>
	    <input type="text" id="email" name="email" required><br>
	
	    <label for="address">Enter Address:</label><br> <br>
	    <textarea id="address" name="address" rows="4" required></textarea><br> <br>
	
	    <input type="submit" value="Submit">
	    <input type="reset" value="Reset">
	</form>

</body>
</html>