<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function checkJoin(){
		if (confirm("기입하신 내용이 맞습니까?? ") == true){ 
		    document.form1.submit();
		}else{   
			//취소 시 join_input.html로 이동.
		   location.href="${pageContext.request.contextPath}/html/join_input.html";
		}
	}
</script>
	<meta charset="UTF-8">
<title>회원 가입 내용 확인</title>
</head>
<body onload="checkJoin()">
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
	<form id="form1" name="form1" action="Join.do">
		<input type="hidden" name="userId" value='${userId}'/>
		<input type="hidden" name="userName" value='${userName}'/>
		<input type="hidden" name="userEmail" value='${userEmail}'/>
		<input type="hidden" name="userPhoneNumber" value='${userPhoneNumber}'/>
		<input type="hidden" name="userZipcode" value='${userZipcode}'/>
		<input type="hidden" name="userAddress" value='${userAddress}'/>
		<input type="hidden" name="joinCheck" value="success"/>
	</form>
</body>
</html>