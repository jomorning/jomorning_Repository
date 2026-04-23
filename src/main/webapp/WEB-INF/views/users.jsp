<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<h2>사용자 목록</h2>

	<c:url value="/logout" var="logoutURL" />
	<form action="${logoutURL}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>
	<br>

	<c:forEach var="user" items="${userList}">
		<img src="<c:url value='/jomorning_upload/${user.fileName}'/>"
			style="width: 3%">
		<br>
		번호: ${user.userNumber}<br>
		ID: ${user.userId}<br>
		PW: ${user.userPw}<br>
		이름: ${user.userName}<br>
		나이: ${user.userAge}<br>
		메일: ${user.userEmail}<br>
		국가: ${user.userCountry}<br>
		<br>
		<a href="<c:url value='/users/${user.userNumber}'/>">상세 정보</a>
		<hr>
	</c:forEach>

	<c:forEach var="page" begin="1" end="${totalPages}">
		<a href="<c:url value='/users?pageNum=${page}'/>">${page}</a>
	</c:forEach>

</body>
</html>