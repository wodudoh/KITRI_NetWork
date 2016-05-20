<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::글 보기 :::</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일자</th>
	</tr>
	<tr>
		<td>${BV.board_id}</td>
		<td>${BV.title}</td>
		<td>${BV.writer}</td>
		<td>${BV.read_cnt}</td>
		<td>${BV.wdate}</td>
	</tr>
	<tr>
		<th colspan="3">추천</th>
		<th colspan="3">비추천</th>
	</tr>
	<tr>
		<th colspan="3">${BV.con_like}</th>
		<th colspan="3">${BV.con_unlike}</th>
	</tr>
	<tr>
		<th colspan="5">첨부파일</th>
	</tr>
	<tr>
		<td colspan="5"><c:choose>
				<c:when test="${BV.pds_link eq null }">첨부 파일 없음</c:when>
				<c:otherwise>${BV.pds_link}</c:otherwise>
		</c:choose></td>
	</tr>
	<tr>
		<th>본문 내용</th>
		<td colspan="4"><textarea rows="40" cols="100" readonly="readonly">${BV.contents}</textarea></td>
	</tr>

	</table>
</body>
</html>