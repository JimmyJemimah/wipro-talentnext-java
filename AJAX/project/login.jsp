<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>XYZ Library - Login</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        .error-header { color: red; font-size: 16px; font-weight: bold; margin-bottom: 15px; }
        .form-group { margin-bottom: 12px; }
        label { display: inline-block; width: 100px; }
        input[type="text"], input[type="password"] { padding: 6px; width: 220px; }
    </style>
</head>
<body>

    <!-- Display error at top if login fails -->
    <%
        String error = (String) request.getAttribute("errorMessage");
        if (error != null) {
    %>
        <div class="error-header"><%= error %></div>
    <%
        }
    %>

    <h2>XYZ Library - User Login</h2>

    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required />
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div class="form-group">
            <input type="submit" value="Login" />
        </div>
    </form>

</body>
</html>