<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 사용자 등록</title>
</head>
<body>
	<h2>신규 사용자 등록</h2>
	
	<c:url value="/users" var="addUserURL"/>
	
	<form:form action="${addUserURL}" modelAttribute="addUser" method="post" enctype="multipart/form-data">
		(신규) ID: <form:input type="text" path="userId"/><br>
		(신규) PW: <form:input type="password" path="userPw"/><br>
		(신규) 이름: <form:input type="text" path="userName"/><br>
		(신규) 나이: <form:input type="number" path="userAge"/><br>
		(신규) 메일: <form:input type="email" path="userEmail"/><br>
		(신규) 국가: <form:input type="country" path="userCountry"/><br>
		(신규) 사진: <form:input type="file" path="multipartFile"/><br><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button>등록</button>
	</form:form>
</body>
</html>