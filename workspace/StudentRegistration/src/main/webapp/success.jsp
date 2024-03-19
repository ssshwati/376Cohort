<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.softra.model.Student" %>
<%@ page import="com.dao.StudentDao" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
    <h1>Student Information</h1>
     <%-- Retrieve the student object from request scope --%>
    <c:set var="student" value="${requestScope.student}" />

    <p><strong>Name:</strong> ${student.name}</p>
    <p><strong>Age:</strong> ${student.age}</p>
    <p><strong>Mobile:</strong> ${student.mobile}</p>
    <p><strong>Email:</strong> ${student.email}</p>
    <p><strong>Address:</strong> ${student.address}</p>
</body>
</html>


