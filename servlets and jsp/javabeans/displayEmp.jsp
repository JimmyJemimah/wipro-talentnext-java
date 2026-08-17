<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="com.bean.EmployeeBean" scope="request" />
<jsp:setProperty name="emp" property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h2>Employee Details (Auto-Populated)</h2>
    <p><b>Employee Name:</b> <jsp:getProperty name="emp" property="empName" /></p>
    <p><b>Employee ID:</b> <jsp:getProperty name="emp" property="empId" /></p>
</body>
</html>