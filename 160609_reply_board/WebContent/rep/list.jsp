<%@ page language="java" contentType="text/JSON; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[
<c:forEach var="list" items="${list}" varStatus="status" >
	<c:if test="${not status.first }">,</c:if>
	{num:${list.num}, name:'${list.name}', content:'${list.content}'}
 </c:forEach>

]
