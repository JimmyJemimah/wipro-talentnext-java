<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="BidBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bid Submitted</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .yellow-box { background-color: #ffff00; padding: 25px; width: 480px; text-align: center; margin: 0 auto; border: 1px solid #ccc; }
        table { width: 50%; margin: 15px auto; border-collapse: collapse; background-color: #ffffcc; }
        td { border: 1px solid #444; padding: 6px 12px; font-size: 13px; text-align: center; font-weight: bold; }
        .header-cell { background-color: black; color: white; font-size: 15px; text-transform: uppercase; }
    </style>
</head>
<body>
    <% BidBean bid = (BidBean) request.getAttribute("bidBean"); %>
    <div class="yellow-box">
        <h1>Bid Submitted</h1>
        <p>Your bid is now active. If your bid is successful, you will be notified within 24 hours of the close of bidding.</p>
        
        <% if (bid != null) { %>
        <table>
            <tr>
                <td class="header-cell"><%= bid.getItemName() %></td>
            </tr>
            <tr>
                <td>Item ID: <%= bid.getItemId() %></td>
            </tr>
            <tr>
                <td>Name: <%= bid.getName() %></td>
            </tr>
            <tr>
                <td>Email address: <%= bid.getEmail() %></td>
            </tr>
            <tr>
                <td>Bid price: Rs <%= bid.getAmount() %></td>
            </tr>
            <tr>
                <td>Auto-increment price: <%= bid.isAutoIncrement() %></td>
            </tr>
        </table>
        <% } %>
    </div>
</body>
</html>