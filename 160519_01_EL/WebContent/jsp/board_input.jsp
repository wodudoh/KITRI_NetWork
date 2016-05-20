<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function w_accept(){
	var form1 = document.board_form;
	form1.p_code.value="write_ok";
	form1.submit();
	
}
</script>

<meta charset="UTF-8">
<title>::: 글 작성 :::</title>
</head>
<body>
<form action="write.do" method="post" name="board_form">
<table border="1">
	<tr>
		<th>글제목</th>
		<th>작성자</th>
		<th>비밀번호</th>
	</tr>
	<tr>
		<td><input type="text" name = "title"></td>
		<td><input type="text" name = "writer"></td>
		<td><input type="text" name = "password"></td>
	</tr>
	<tr>
		<th colspan="3">첨부파일</th>
	</tr>
	<tr>
		<td colspan="3">
				<input type="file" name="pds_link"/>
		</td>
	</tr>
	<tr>
		<th>본문 내용</th>
		<td colspan="2"><textarea rows="40" cols="100" name="contents"></textarea></td>
	</tr>

	</table>
	<p><input type="button"  value="작성" onclick="w_accept()"/></p>
	<input type="hidden" name="p_code">
</form>

</body>
</html>