<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 Ajax Application</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/httpRequest.js"></script>
<script type="text/javascript">
	
	function load(url){
		var txt = document.getElementById("name");
		var param = "name=" + txt.value;
		
		sendRequest(url, param, viewMessage, "POST");
	}
	function viewMessage(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				var result =httpRequest.responseText;
				var mySpan = document.getElementById("mySpan");
				mySpan.innerHTML = result;
			}else{
				alert("실패 : " + httpRequest.status);
			}
		}
	}

</script>
</head>
<body>
<input type="text" id="name"/>
<span id ="mySpan" ></span>
<input type="button" value="simple.jsp" onclick="load('simple.jsp')"/>

</body>
</html>