<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
var rem;
var firstRem=0;

window.onload=function() {
	repList();
}

	function repList(){
		sendRequest("${pageContext.request.contextPath}/RepController", "code=getList", prtList, "POST");
	var repList2 = document.getElementById('repList');
	
	repList2.innerHTML = "";
		setTimeout(repList,1500);
	}
	
	function prtList() {
	   if (httpRequest.readyState == 4) {
	      if (httpRequest.status == 200) {
	         
	    	  if(firstRem<1){
	    	  var res = httpRequest.responseText;
				rem = res;	  
	    	  }
	    	  var res = rem;
	    	 firstRem += 1;
	         
	         var repList = eval("(" + res + ")");            
	         for (i = 0; i < repList.length; i++) {
	            makeRepDiv(repList[i]);
	         }
	      }
	   }
	}
function makeRepDiv(rep){
	var RepDiv = document.createElement('div');
	RepDiv.setAttribute('id', 'rep_'+rep.num);
	var html = "name : " + rep.name + "<br/>"
	+"content : " + rep.content + "<br/>"
	+"<input type='button' value='수정' onclick='delReply("+rep.num+")' >"
	+"<input type='button' value='삭제' onclick='updateReply("+rep.num+")' >";
	RepDiv.innerHTML = html;
	var repList = document.getElementById("repList");
	repList.appendChild(RepDiv);
	
}

function delReply(repNum){
	alert(repNum+"지울 번호");
}
function updateReply(repNum){
	alert(repNum+"수정할 번호");
	
}
function addRep(){
	var param = "type=addRep&name=" + document.f.name.value + "&content=" + document.f.content.value;
	sendRequest("${pageContext.request.contextPath}/RepController", param, addResult, "POST");
	
}function addResult() {
	   if (httpRequest.readyState == 4) {
		      if (httpRequest.status == 200) {
		         var str = httpRequest.responseText;
		         var repList = eval("(" + rtr + ")");            
		            makeRepDiv(repList[i]);
		       }
		   }
		}


</script>



<meta charset="UTF-8">
<title>::리플 작성::</title>
</head>
<body>
	<form name="f">
		<table border='1'>
			<tr>
				<th>name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="작성"></td>
			</tr>
		</table>
		<div id="repList"></div>
	</form>
</body>
</html>