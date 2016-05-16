<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
<script type="text/javascript">
function loginChk(){
	if("${adm_id}"=="admin"){
		alert('${adm_id}'+"님 정상적으로 로그인 되었습니다.");
		var form1=document.form1;
		var id = '${adm_id}';
		var pass = '${adm_pass}';
		form1.adm_id.value= id;
		form1.adm_pass.value= pass;
		form1.m_code.value="adm_login_ok";
		form1.submit();
	}else{
		alert('${param.adm_id}'+"은 관리자 계정이 아닙니다. 이전 페이지로 돌아갑니다.");
		location.href="../../html/admin_input.html";
	}
}
</script>

</head>
<body onload="loginChk()">
<form action="admin.do" method="get" name="form1">
	<input type="hidden" id="adm_id" name="adm_id"/>
	<input type="hidden" id="adm_pass" name="adm_pass"/>
	<input type="hidden" id="m_code" name="m_code" />
</form>


</body>
</html>