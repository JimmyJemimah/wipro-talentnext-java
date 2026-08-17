<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="com.bean.Employee" scope="request" />
<jsp:setProperty name="emp" property="*" />
<jsp:forward page="AddEmployeeServlet" />