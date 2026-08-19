<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome to Home Page, <%= session.getAttribute("user") %>!</h2>
    <a href="login.jsp">Logout</a>
</body>
</html>