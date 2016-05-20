<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function login(){
	// Controller
	// p_code = 특정 값이 들어가도록 입력
	// p_code = login_chk
	if(document.loginForm.p_empno.value==""){
		alert("사원번호를 입력하시기 바랍니다.");
		document.loginForm.p_empno.focus();
	}else if(document.loginForm.p_ename.value==""){
		alert("사원이름을 입력하시기 바랍니다.");
		document.loginForm.p_ename.focus();
	}else{
		document.loginForm.p_code.value = "login_chk";
		document.loginForm.submit();
	}
}

function join(){
	// Controller
	// p_code = user_reg
}

function keyevent(){
	// 키보드에서 Enter키가 눌렸을 시 동작할 수 있도록 함.
	if(event.keyCode == 13){
		login();
	}
}

function rechk(){
		<% HttpSession hs = request.getSession(); %>
		if('<%=hs.getAttribute("code")%>'=="login_chk"){
			location.href="login_ok.jsp"
		}
		
}
	

</script>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action = "login.do"  method="post" name="loginForm">
	<p>사원 번호 : <input id="p_empno" name="p_empno" type= "text" onkeydown="keyevent()"/></p>
	<p>사원 이름 : <input name="p_ename" type= "text" onkeydown="keyevent()"/></p>
	<input name="p_code" type= "hidden"/>
	
	<p><input name = "p_buttion" type="button" value="로그인" onclick="login()"/></p>
	<p><input name = "b_buttion" type="button" value="회원가입" onclick="join()"/></p>

</form>
</body>
</html>