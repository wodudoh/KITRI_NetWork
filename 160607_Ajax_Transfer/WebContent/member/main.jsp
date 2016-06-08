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

	function JsonAllMember() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var JsonDoc = httpRequest.responseText;
				var o = eval("(" + JsonDoc + ")");
				var JsonValue = document.getElementById("JsonValue");
				var message = "멤버 인원 : " + o.length + "명 <br/><table id='member_"+i+"'>";
				for (var i = 0; i < o.length; i++) {
					message += "<tr>"+"<td>학번 : " + o[i].num + "</td><td>" + "이름 : " + o[i].name
							+ "</td><td>" + "전화 : " + o[i].tel + "</td><td>" + "이메일 : "
							+ o[i].email + "</td><td>" + "부(서) : " + o[i].dept + "</td><td>" + "직업 : ";
							
							if(o[i].type == 1){
								message +="교직원";
							}else if(o[i].type == 2){
								message += "교수";
							}else if(o[i].type == 3){
								message += "학생";
							}
							message += " <input type='button' onclick = 'deleteMember(o[i].num, )'value='삭제' /> </td></tr>";
							
				}
				
				message +="</table>";
				JsonValue.innerHTML = message;
			}
		}
	}
	function deleteMember(num){
		
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
		<span id="xmlValue"></span> <span id="JsonValue"></span>
	</p>


</body>
</html>