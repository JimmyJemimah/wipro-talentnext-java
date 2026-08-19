<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .box { width: 320px; border: 1px solid #ccc; padding: 20px; margin: 0 auto; }
        .msg { color: red; font-weight: bold; margin-bottom: 10px; }
        .links { margin-top: 15px; }
    </style>
</head>
<body>
    <div class="box">
        <h2>Login</h2>
        <% 
            String msg = (String) request.getAttribute("message");
            if (msg != null) { 
        %>
            <div class="msg"><%= msg %></div>
        <% } %>
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action" value="login">
            <div>
                <label>User Name:</label><br>
                <input type="text" name="username" required>
            </div><br>
            <div>
                <label>Password:</label><br>
                <input type="password" name="password" required>
            </div><br>
            <input type="submit" value="Submit">
        </form>
        <div class="links">
            <a href="newUser.html">New User</a> | 
            <a href="changePassword.html">Change Password</a>
        </div>
    </div>
</body>
</html>