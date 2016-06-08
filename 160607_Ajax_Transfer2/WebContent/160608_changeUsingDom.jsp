<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr" />
<title>DOM을 사용한 변경</title>
<script type="text/javascript">
	var count = 0;
	function appendItem() {
		count++;
		var newItem = document.createElement("div");
		newItem.setAttribute("id", "item_" + count);
		var html = '새로 추가된 아이템[' + count + ']' + '<input type="button" value="삭제" onclick="removeItem('+count+')"/>';
		newItem.innerHTML = html;
		
		var itemListNode = document.getElementById('itemList');
		itemListNode.appendChild(newItem);
	}
	function removeItem(idCount) {
		var item = document.getElementById("item_" + idCount);
		if (item != null) {
			item.parentNode.removeChild(item);
		}
	}
</script>
</head>
<body>
	<input type='button' value='추가' onclick='appendItem()' />
	<div id="itemList"></div>
</body>
</html>