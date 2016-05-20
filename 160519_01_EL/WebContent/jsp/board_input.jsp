<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function w_accept(c) {

		var form1 = document.board_form;

		if (c == "mod") {
			form1.p_code.value="modify_ok";			
		} else if (c == "add") {
			form1.p_code.value = "write_ok";
		}
			form1.submit();
	}
</script>

<meta charset="UTF-8">

<title><c:choose>
		<c:when test="${BDTO ne null }">::: 글 수정 :::</c:when>
		<c:otherwise>::: 글 작성 :::</c:otherwise>
	</c:choose></title>
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
				<td><input type="text" name="title"
					value='<c:if test="${BDTO ne null}">${BDTO.title}</c:if>'></td>
				<td><input type="text" name="writer"
					value='<c:if test="${BDTO ne null}">${BDTO.writer}</c:if>'></td>
				<td><input type="text" name="password"
					value='<c:if test="${BDTO ne null}">${BDTO.password}</c:if>'></td>
			</tr>
			<tr>
				<th colspan="3">첨부파일</th>
			</tr>
			<tr>
				<td colspan="3"><input type="file" name="pds_link" /></td>
			</tr>
			<tr>
				<th>본문 내용</th>
				<td colspan="2"><textarea rows="40" cols="100" name="contents"></textarea></td>
			</tr>

		</table>
		<c:choose>
			<c:when test="${BDTO ne null}">
				<p>
					<input type="button" value="수정" onclick="w_accept('mod')" />
				</p>
			</c:when>
			<c:otherwise>
				<p>
					<input type="button" value="작성" onclick="w_accept('add')" />
				</p>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="p_code">
		<input type="hidden" name="b_id" value="${b_id}">
	</form>

</body>
</html>