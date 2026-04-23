<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test 1</title>
</head>
<body>
	<button id="b1">테스트 케이스 1</button>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		const btn1 = document.querySelector('#b1');
		btn1.addEventListener('click', case1);
		
		function case1() {
			console.log("case1() 메서드 실행");
			let obj = {name: "kim", age: 30};
			
			$.ajax({
				url: "/jomorning/case1",
				type: "POST",
				data: JSON.stringify(obj),
				contentType: "application/json",
				success: function(data) { alert("success"); },
				error: function(errorThrown) { alert("fail"); } 
			});
		}
	</script>
</body>
</html>