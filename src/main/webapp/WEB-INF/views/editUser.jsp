<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body>
	<h2>사용자 정보 수정</h2>
	
	<c:url value="/users/${editUser.userNumber}" var="editUserURL"/>
	
	<form:form action="${editUserURL}" modelAttribute="editUser" method="put" enctype="multipart/form-data">
		(고정) 번호: <form:input readonly="true" path="userNumber"/><br>
		(수정) ID: <form:input type="text" path="userId"/><br>
		(수정) PW: <form:input type="password" path="userPw"/><br>
		(수정) 이름: <form:input type="text" path="userName"/><br>
		(수정) 나이: <form:input type="number" path="userAge"/><br>
		(수정) 메일: <form:input type="email" path="userEmail"/><br>
		(수정) 국가: <form:input type="country" path="userCountry"/><br>
		(수정) 사진: <form:input type="file" path="multipartFile"/><br><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button>수정</button>
		<a href="<c:url value='/users'/>">전체 사용자 목록</a>
	</form:form>
	
</body>
</html>