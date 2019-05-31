<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h2>${msg}</h2>

<a href="/user/login">로그인하기</a>
<a href="/echo">채팅방 입장하기</a>
<a href="/admin/adminhome">관리자 페이지</a>
<a href="/logout">로그아웃</a>
</body>
</html>
