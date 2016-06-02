<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function edit(){
		var frm = document.frm;
		frm.type.value="edit";
		frm.submit();
	}
	function logout(){
		var frm = document.frm;
		frm.type.value ="logout";
		frm.submit();
	}

</script>
<title>::학사 관리 프로그램 Main::</title>
</head>
<body>
	<%=session.getAttribute("num")%>님 로그인 성공!
	<br>
	<form name=frm action="MemberController" method="post">
		<input type="hidden" name="type" value=""> <input
			type="hidden" name="num" value="<%=request.getAttribute("num")%>">
		<input type="button" value="정보수정" onclick="edit()"> <input
			type="button" value="로그아웃" onclick="logout()">
	</form>

</body>
</html>