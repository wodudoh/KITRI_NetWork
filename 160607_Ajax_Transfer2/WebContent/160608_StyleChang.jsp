<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function a(){
		var myFont = document.getElementById("x");
		var size=  myFont.getAttribute("size");
		alert("size:"+ size);
		myFont.setAttribute("color", "red");
		myFont.setAttribute("face", "궁서");
}

</script>
</head>
<body>
<font id="x" size="10">읭읭ㅇ의으이읭의의으잉</font>
<input type="button" onclick="a()" >

</body>
</html>