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
	<script >
		function join(){
			location.href="${path}/user/join";
		}
	</script>
	<h2>로그인 페이지</h2>
	<span style="color:red;">${errMsg}</span>
	<form action="${path}/user/check" method="post">
		<input type="text" name="username">
		<input type="text" name="password">
		<input type="checkbox" name="_spring_security_remember_me">
		<input type="submit">
		<input type="button" value="회원가입" onclick="join()">
	</form>
</body>
</html>