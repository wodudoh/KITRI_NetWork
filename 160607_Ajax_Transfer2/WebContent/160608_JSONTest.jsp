<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
function a(){
	 sendRequest("160608_JSON1.jsp", null, result, "GET");
}

function result(){
	if(httpRequest.readyState == 4){
		if(httpRequest.status ==200){
			var res = httpRequest.responseText;
			var o = eval("("+res+")");
			var testJSON = document.getElementById("testJSON");
			for(var i = 0 ; i < o.length; i++){
				testJSON.innerHTML += o[i].flag;
				testJSON.innerHTML += o[i].haha;
				testJSON.innerHTML += o[i].etc;
				testJSON.innerHTML += "<br/>";
			}
		}
	}
}


</script>
</head>
<body>
<input type="button" value="클릭" onclick="a()" />
<span id="testJSON"></span>
</body>
</html>