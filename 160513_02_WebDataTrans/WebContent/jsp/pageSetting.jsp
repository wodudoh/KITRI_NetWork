<!--  특정부분의 api 삽입을 위한 Directive를 선언할 수 있다. -->
<%@page import="java.util.Enumeration"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지에 관련한 설정</title>
<% String test = "test"; 
	ArrayList<String> al  = new ArrayList<String>();
%>
</head>
<body>
<% int sum = 0;

	for(int i=1;i<=10;i++){
		sum = sum + i;
	}
%>

<p> 1부터 10까지 합은 <%=sum %> 이다.</p>
<%
	Enumeration headEnum = request.getHeaderNames();
	while(headEnum.hasMoreElements()){
		String headerName= (String)headEnum.nextElement();
		String headerValue = request.getHeader(headerName);
		out.print(headerName);
		out.print(" : ");
		out.print(headerValue+"<br>");
	}
%>

</body>
</html>