<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 번호 없음</title>
</head>
<body>
	<p> 유저번호 ${invalidUserNumber} == 존재하지 않음. (예외 발생됨)
	<p> 발생한 예외 클래스: ${exception}
	<p> 요청 URL 경로: ${url1}
	<p> 요청 쿼리문: ?${url2}
</body>
</html>