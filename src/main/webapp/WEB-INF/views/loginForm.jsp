<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>

	<c:url value="/login" var="loginURL" />

	<form action="${loginURL}" method="post">
		<input type="text" name="username" placeholder="아이디를 입력하세요."/><br>
		<input type="password" name="password" placeholder="비밀번호를 입력하세요."/><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
		<button>로그인</button>
	</form>
</body>
</html>