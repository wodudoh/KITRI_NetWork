<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function loadBooks() {
		sendRequest("160608_viewBooks.jsp", null, loadedBooks, "GET");
	}
	function loadedBooks() {
		if(httpRequest.readyState ==4){
			if(httpRequest.status == 200){
				var xmlDoc = httpRequest.responseXML;
				alert(xmlDoc);
				var bookList = xmlDoc.getElementsByTagName("book");
				var message = "책 개수 : " + bookList.length + "권\n";
				for(var i = 0; i < bookList.length ; i++){
					var book = bookList.item(i);
					var titleValue = book.getElementsByTagName("title")[0].firstChild.nodeValue;
					var authorValue = book.getElementsByTagName("author")[0].firstChild.nodeValue;
					message += titleValue + "(" + authorValue + ")\n";
				}
				alert(message);
			}
		}
	}
	
	window.onload = function(){
		loadBooks();
	}

</script>
<meta charset="UTF-8">
<title>Ajax를 활용한 XML 전송 방법</title>
</head>
<body>

</body>
</html>