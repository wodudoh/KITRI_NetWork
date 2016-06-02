<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="MemberController" method="post">
		NUM: <input type="text" readonly="readonly" value="${Member.num}" name="num"><br>
		EMAIL: <input type="text" value="${Member.email}" name="email"><br>
		TEL: <input type="text" value="${Member.tel}" name="tel"><br>
		<input type="hidden" value="editInfo" name="type">
		<input type="submit" value="수정완료">
	</form>

</body>
</html>