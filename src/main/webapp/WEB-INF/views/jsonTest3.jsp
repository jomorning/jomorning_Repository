<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test 3</title>
</head>
<body>
	<input type="text" id="text3" />
	<button id="b3">테스트 케이스 3</button>
	
	<div id="result3"></div>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		const btn3 = document.querySelector('#b3');
		btn3.addEventListener('click', case3);

		function case3() {
			console.log("case3() 메서드 실행");
			let inputData = document.querySelector('#text3').value;
			console.log(inputData);

			$
					.ajax({
						url : "/jomorning/case3",
						type : "POST",
						data : JSON.stringify({
							id : inputData
						}),
						contentType : "application/json",
						success : function(data) {
							console.log(data);
							alert('success');
							document.querySelector('#result3').innerHTML = "서버 응답 아이디: "
									+ data.id
									+ "<br>"
									+ "서버 응답 메세지: "
									+ data.msg;
						},
						error : function(errorThrown) {
							alert('fail');
							console.log(errorThrown);
						}
					});
		}
	</script>
</body>
</html>