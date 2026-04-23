<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
</head>
<body>
	<h2>사용자 정보</h2>
	
		<img src="<c:url value='/jomorning_upload/${one.fileName}'/>" style="width: 10%">
		<br>
		
		번호: ${one.userNumber}<br>
		ID: ${one.userId}<br>
		PW: ${one.userPw}<br>
		이름: ${one.userName}<br>
		나이: ${one.userAge}<br>
		메일: ${one.userEmail}<br>
		국가: ${one.userCountry}
	
	<br>
	<br>

		<a href="<c:url value='/users/${one.userNumber}/edit'/>">수정</a>
		<br>
		<c:url value="/users/${one.userNumber}" var="deleteUserURL"/>
		<form:form action="${deleteUserURL}" method="delete">
			<button>삭제</button>
		</form:form>
		<br>
		<a href="<c:url value='/users'/>">전체 사용자 목록</a>
		
</body>
</html>