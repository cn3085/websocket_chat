<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<form action="/user/check" method="post">
		<input type="text" name="username">
		<input type="text" name="password">
		<input type="checkbox" name="_spring_security_remember_me">
		<input type="submit">
	</form>
</body>
</html>