<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function b_del(){
	var form2 = document.f_delete;
	form2.p_code.value="chk_pass_input";
	form2.p_bid.value="${param.p_bid}";
	form2.submit();
}
function del_fail(){
	var form2 = document.f_delete;
	var state = "${param.state}";
	if(state =="fail"){
		alert("비밀번호가 틀렸습니다. 다시 입력하세요.");
		form2.password.value="";
		form2.password.focus();
	}
}
</script>

<meta charset="UTF-8">
<title>:::패스워드를 입력하세요:::</title>
</head>
<body onload="del_fail()">

<form action="read.do" name="f_delete" method="post">
	<input type="password" name = "p_chk" />
	<input type="hidden" name="p_code" />
	<input type="hidden" name="p_bid" />
	<input type="button" value="확인" onclick="b_del()"/>
</form>


</body>
</html>