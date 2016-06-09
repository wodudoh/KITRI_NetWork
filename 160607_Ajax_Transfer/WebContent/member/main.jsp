<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function edit() {
		var frm = document.frm;
		frm.type.value = "edit";
		frm.submit();
	}
	function logout() {
		var frm = document.frm;
		frm.type.value = "logout";
		frm.submit();
	}
	function callAllMember() {
		//		var url = "${pageContext.request.contextPath}/MemberController?type=MemberXMLAll";
		var url = "${pageContext.request.contextPath}/MemberController?type=MemberJSONAll";
		//sendRequest(url, null, ajaxAllMember, "GET");
		sendRequest(url, null, JsonAllMember, "GET");
	}
	function ajaxAllMember() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var xmlDoc = httpRequest.responseXML;
				var txtDoc = httpRequest.responseText;
				alert(txtDoc);
				var xmlValue = document.getElementById("xmlValue");
				var memberList = xmlDoc.getElementsByTagName("member");
				var message = "멤버 : " + memberList.length + "인원 <br/>";
				for (var i = 0; i < memberList.length; i++) {
					var memberValue = memberList.item(i);
					var numValue = memberValue.getElementsByTagName("num")[0].firstChild.nodeValue;
					var nameValue = memberValue.getElementsByTagName("name")[0].firstChild.nodeValue;
					var telValue = memberValue.getElementsByTagName("tel")[0].firstChild.nodeValue;
					var emailValue = memberValue.getElementsByTagName("email")[0].firstChild.nodeValue;
					var deptValue = memberValue.getElementsByTagName("dept")[0].firstChild.nodeValue;
					var typeValue = memberValue.getElementsByTagName("type")[0].firstChild.nodeValue;

					message += "학번:" + numValue + "<br/>" + "이름 : " + nameValue
							+ "<br/>" + "전화" + telValue + "<br/>" + "이메일"
							+ emailValue + "<br/>" + "부(서)" + deptValue
							+ "<br/>" + "직업" + typeValue + "<br/>"

				}
				xmlValue.innerHTML = message;
			}
		}

	}
	var o;
	function JsonAllMember() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var JsonDoc = httpRequest.responseText;
				o = eval("(" + JsonDoc + ")");
				var JsonValue = document.getElementById("JsonValue");
				var message = "멤버 인원 : " + o.length + "명 <br/><table id='member_"+i+"'>";
				for (var i = 0; i < o.length; i++) {
					message += "<tr id='tr_"+i+"'><td onmouseover ='a(o["+i+"])' onmouseout='b()' >" + "이름 : " + o[i].name + "</td><td> <input type='button' onclick = 'deleteMember(o["+i+"].num, tr_"+i+")' value='삭제' /> </td></tr>";
				}
				message +="</table>";
				JsonValue.innerHTML = message;
			}
		}
	}
	function deleteMember(num, tr_id){
		if(window.confirm("학번'num'를 진심으로 지우실건가요?")){
			alert(tr_id+"지워졌습니다.")
		}
		
		
	}
	
	function b(o){
		var memberInfo = document.getElementById("memberInfo");
		memberInfo.innerHTML = "";
	}
	
	function a(o2){
		var memberInfo = document.getElementById("memberInfo");
		var htmlMessage = 
			"<table><tr><th>멤버 상세정보</th></tr> <tr><th>학번 : </th><td>"+o2.num+"</td></tr> <tr><th>이름 : </th><td>"+o2.name+"</td></tr> <tr><th>전화 : </th><td>"+o2.tel+"</td></tr> <tr><th>이메일 : </th><td>"+o2.email+"</td></tr><tr><th>부서 : </th><td>"+o2.dept+"</td></tr> <tr><th>직업 : </th><td>";
			if(o2.type == 1){
			htmlMessage += "교직원</td></tr><table>";
			} else if(o2.type ==2 ){
				htmlMessage += "교수</td></tr><table>";
			} else if(o2.type == 3){
				htmlMessage += "학생</td></tr><table>";
			}
		memberInfo.innerHTML = htmlMessage;
	}
</script>
<title>::학사 관리 프로그램 Main::</title>
</head>
<body>
	<%=session.getAttribute("num")%>님 로그인 성공!
	<br>
	<form name=frm action="MemberController" method="post">
		<input type="hidden" name="type" value=""> <input
			type="hidden" name="num" value="<%=request.getAttribute("num")%>">
		<input type="button" value="정보수정" onclick="edit()"> <input
			type="button" value="로그아웃" onclick="logout()">
	</form>

	<input type="button" value="모든사용자" onclick="callAllMember()">
	<p>
		<span id="xmlValue"></span> <span id="JsonValue"></span><br/>
		<span id="memberInfo"></span>
	</p>


</body>
</html>