<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 결과</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
입력받은 결과값
	<table>
		<tr>
			<td>입력된 아이디</td>
			<td>${userId}</td>
		</tr>
		<tr>
			<td>입력된 이름</td>
			<td>${userName}</td>
		<tr>
			<td>입력된 이메일</td>
			<td>${userEmail}</td>
		</tr>
		<tr>
			<td>입력된 핸드폰 번호</td>
			<td>${userPhoneNumber}</td>
		</tr>
		<tr>
			<td>입력된 우편번호</td>
			<td>${userZipcode}</td>
		</tr>
		<tr>
			<td>입력된 주소</td>
			<td>${userAddress}</td>
		</tr>

	</table>
</body>
</html>