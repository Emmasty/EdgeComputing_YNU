<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>manager</title>
</head>
<body>
<%
String name=(String)session.getAttribute("name");
String psw=(String)session.getAttribute("psw");
%>
姓名:<%=name %><br>
密码:<%=psw %><br>
用户身份:管理员
</body>
</html>