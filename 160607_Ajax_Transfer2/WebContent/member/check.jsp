<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function load(){
	<c:choose>
	<c:when test="${Checkedid eq 'true'}">
	alert("사용 가능한 학번입니다.");
	</c:when>
	<c:when test="${Checkedid eq 'false'}">
		alert("이미 존재하는 학번이 있습니다.");
		document.frm.num.value="";
	</c:when>
	</c:choose>
}

function check(){
	document.getElementsByName("frm")[0].submit();
	document.getElementsByName("Checkedid")[0].value="${Checkedid}";
	
}
function useNum(){
	opener.document.frm.num.value = document.frm.num.value;
	opener.document.frm.Checkedid.value = document.frm.Checkedid.value;
	close();
}

</script>
<meta charset="UTF-8">
<title>:: 학사관리시스템 - 번호 중복 체크 ::</title>
</head>
<body onload="load()">
<h1>번호 중복 체크 </h1>
<form action="${pageContext.request.contextPath}/MemberController" name="frm" method="post">
	<table>
	<tr><td>NUM: <input type="text" name="num" value="${param.num}"/> <input type="button" name ="checkId" onclick="check()" value="중복체크"/>
	<input type="hidden" name="type" value="checkId"/>
	<input type="hidden" name="Checkedid" value="${Checkedid}"/>
	</td>
	</tr>
	
	<tr><td><input type="button" name ="checkId" onclick="useNum()" value="번호사용"/></td></tr>
	</table>
</form>

</body>
</html>