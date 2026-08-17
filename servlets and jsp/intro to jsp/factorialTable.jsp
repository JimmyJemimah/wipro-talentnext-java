<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Factorial Table</title>
</head>
<body>
    <h2>Numbers and Their Factorial Values</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr bgcolor="#cccccc">
            <th>Number (n)</th>
            <th>Factorial (n!)</th>
        </tr>
        <%!
            long calculateFactorial(int n) {
                long fact = 1;
                for (int i = 1; i <= n; i++) {
                    fact *= i;
                }
                return fact;
            }
        %>
        <%
            for (int i = 1; i <= 10; i++) {
        %>
        <tr>
            <td><%= i %></td>
            <td><%= calculateFactorial(i) %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>