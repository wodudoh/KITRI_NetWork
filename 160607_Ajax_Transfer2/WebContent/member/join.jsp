<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function check(){
	var form1 = document.getElementsByName("frm")[0];
	window.open("member/check.jsp?num="+form1.num.value, "", "width=400px, height=300px, history=no, resizable=no, status=no, scrollbars=no");
}

function test(){
	var checkid = document.frm.Checkedid.value;
	if(checkid == "true"){
		document.frm.submit();
	}else{
		alert("중복체크를 먼저 수행해주세요.");
	}
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>:: 회원 가입 폼 ::</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/MemberController" name="frm" method="post">
	<table>
	<tr><td>NUM: <input type="text" name="num" id="num"/> <input type="button" name ="checkId" onclick="check()" value="중복체크"/>
	<input type="hidden" name="Checkedid" value="false"/>
	</td></tr>
	<tr><td>NAME: <input type="text" name="name"></td></tr>
	<tr><td>TEL: <input type="text" name="tel"></td></tr>
	<tr><td>EMAIL: <input type="text" name="email"></td></tr>
	<tr><td>DEPT: <input type="text" name="dept"></td></tr>
	<tr><td>유형: &nbsp;&nbsp;&nbsp; 교직원 <input type="radio" name="ty" value="1"> 교수 <input type="radio" name="ty" value="2"> 학생 <input type="radio" name="ty" value="3"></td></tr>			
	<tr><td><input type="hidden" name="type" value="join"></td></tr>
		<tr><td><input type="button" onclick='test()' value='가입'/> <input type="reset" value="취소"></td></tr>
		
	</table>
	</form>
</body>
</html>