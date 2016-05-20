<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function write_board(){
	
	 // 글 작성하는 페이지로 갈 수 있도록 컨트롤러 실행
	 location.href="read.do?p_code=write";
	
}
</script>

<meta charset="UTF-8">
<title>:: KITRI Board List ::</title>
</head>
<body>
	<p>KITRI Borad List</p>

	<table border="1">

		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
			<th>추천</th>
		</tr>
			<c:forEach var="blist" items="${BL}">
		<tr>
				<td>${blist.board_id}</td>
				<td><a href="read.do?p_code=contents&b_id=${blist.board_id}">${blist.title}</a></td>
				<td>${blist.writer}</td>
				<td>${blist.wdate}</td>
				<td>${blist.read_cnt}</td>
				<td>${blist.con_like}</td>
		</tr>
			</c:forEach>
	
	</table>
	<p><input type="button"  value="글쓰기" onclick="write_board()"/></p>
	

</body>
</html>

