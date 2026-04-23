<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test 2</title>
</head>
<body>
	<input type="text" id="text2"/>
	<button id="b2">테스트 케이스 2</button>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		const btn2 = document.querySelector('#b2');
		console.log(btn2);
		btn2.addEventListener('click', case2);
		
		function case2() {
			console.log("case2() 메서드 실행");
			let inputData = document.querySelector('#text2').value;
			console.log(inputData);
			
			$.ajax({
				url: "/jomorning/case2",
				type: "POST",
				data: JSON.stringify( {id:inputData} ),
				contentType: "application/json",
				success: function(data) { alert('success'); },
				error: function(errorThrown) { alert('fail');  }
			});
		}
	</script>
</body>
</html>