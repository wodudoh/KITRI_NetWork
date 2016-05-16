<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function Welcome(){
	alert('${userId}'+"님 가입을 환영합니다~~!!!!");
	
}
</script>
<meta charset="utf-8">
<title>회원가입 결과</title>
</head>
<body onload="Welcome()">

<img src="${pageContext.request.contextPath}/html/img/welcome.jpg" style="position: absolute; left: 50%; top: 50%;  transform: translateX(-50%) translateY(-50%);; "/>

</body>
</html>