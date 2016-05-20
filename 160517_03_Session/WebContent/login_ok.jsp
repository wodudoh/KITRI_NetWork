<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function logout() {
		alert("로그아웃이 정상처리 되었습니다.");
		document.LogoutForm.p_code.value="log_out";
		document.LogoutForm.submit();
	}
	function empMod() {
		//action 바꿔줘야함.
		//document.LogoutForm.p_code.value="emp_update";
		document.LogoutForm.action="emp.do";
		document.LogoutForm.submit();
	}
</script>
<meta charset="UTF-8">
<title>Login OK</title>
</head>
<body>
	<%
		HttpSession hs = request.getSession();
	%>
	<p>로그인에 성공하셨습니다.</p>
	<p>
		사용자 번호 :
		<%=hs.getAttribute("empno")%><br>
	<p>
		사용자 이름 :
		<%=hs.getAttribute("ename")%><br>
	<form name="LogoutForm" method="post" action="login.do">
		<input name="p_code" type="hidden" /> 
		<input name="mod_emp" value="정보수정" type="button" onclick="empMod()" />
		<input name="logout_bt" value="로그아웃" type="button" onclick="logout()" />
	</form>

</body>
</html>