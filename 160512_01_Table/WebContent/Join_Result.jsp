<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 결과</title>
</head>
<body>

	입력받은 결과값
	<table>

		<tr>
			<td>입력된 아이디</td>
			<td><%=request.getParameter("userId") %></td>
		</tr>
		<tr>
			<td>입력된 이름</td>
			<td><%=request.getParameter("userName") %></td>
		<tr>
			<td>입력된 이메일</td>
			<td><%=request.getParameter("userEmail") %>@<%=request.getParameter("userEmail2") %></td>
		</tr>
		<tr>
			<td>입력된 핸드폰 번호</td>
			<td><%=request.getParameter("userPhoneNumber") %></td>
		</tr>
		<tr>
			<td>입력된 우편번호</td>
			<td><%=request.getParameter("userZipcode1") %>&nbsp; - &nbsp; <%=request.getParameter("userZipcode2") %>
		</tr>
		<tr>
			<td>입력된 주소</td>
			<td><%=request.getParameter("userAddress") %></td>
		</tr>

	</table>

</body>
</html>