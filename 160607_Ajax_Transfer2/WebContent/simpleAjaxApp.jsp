<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 Ajax Application</title>
<script type="text/javascript">
	var httpRequest = null;
	function getXMLHttpRequest(){
		if(window.ActiveXObject){
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");	
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
					
				}catch(e1){
					return null;
				}
			}
		}else if (window.XMLHttpRequest){
			return new XMLHttpRequest();
			
		}else {
			return null;
		}
	}
	function load(url){
		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = viewMessage;
		httpRequest.open("GET", url, true);
		httpRequest.send(null);
	}
	function viewMessage(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				alert("원래 텍스트 이런가봐"+httpRequest.responseText);
			}else{
				alert("실패 : " + httpRequest.status);
			}
		}
	}

</script>
</head>
<body>
<input type="button" value="simple.jsp" onclick="load('simple.jsp')"/>

</body>
</html>