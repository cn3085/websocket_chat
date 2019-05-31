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
	<h2>회원가입</h2>
	<span style="color:red;">${errMsg}</span>
	<form action="/user/joinAction" method="post">
		<input type="text" name="username">
		<input type="text" name="password">
		<select name="authority">
			<option value="ROLE_USER">사용자</option>
			<option value="ROLE_ADMIN">관리자</option>
		</select>
		<input type="submit">
	</form>
</body>
</html>