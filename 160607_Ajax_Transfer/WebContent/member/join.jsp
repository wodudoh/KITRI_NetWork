<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="httpRequest.js" ></script>
<script type="text/javascript">
function check(){
	//var form1 = document.getElementsByName("frm")[0];
	//window.open("member/check.jsp?num="+form1.num.value, "", "width=400px, height=300px, history=no, resizable=no, status=no, scrollbars=no");
	var txt = document.getElementById("num");
	var param = "type=checkId&num=" + txt.value;
	var url = "../MemberController";
	sendRequest(url, param, req_check, "POST");
}

function test(){
	var checkFlag = document.getElementsByName("Checkedid")[0].value;
	if(checkFlag == "false"){
		alert("아이디체크 후 진행 하세요");
		document.frm.num.focus();
	}else if(checkFlag == "true"){
		document.frm.submit();
	}
}
function req_check(){
	var checkedid = document.frm.Checkedid;
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			var resultJSON = httpRequest.responseText;
			var result = eval("("+resultJSON+")");
			var idChecked = document.getElementById("idChecked");
			if(result.flag == "true"){
				idChecked.innerHTML = "사용가능 아이디";
				document.getElementsByName("Checkedid")[0].value=result;
			}else if(result.flag == "false"){
				idChecked.innerHTML = "사용불가 아이디";
				document.getElementsByName("Checkedid")[0].value=result;
			}
			
		}else{
			alert("체크를 다시시도하세요");
		}
	}

}



</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: 회원 가입 폼 ::</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/MemberController" name="frm" method="post">
	<table>
	<tr><td>NUM: <input type="text" name="num" id="num"/> <input type="button" name ="checkId" onclick="check()" value="중복체크"/>
	<span id="idChecked"></span>
	<input type="hidden" name="Checkedid" value="false"/>
	</td></tr>
	<tr><td>NAME: <input type="text" name="name"></td></tr>
	<tr><td>TEL: <input type="text" name="tel"></td></tr>
	<tr><td>EMAIL: <input type="text" name="email"></td></tr>
	<tr><td>DEPT: <input type="text" name="dept"></td></tr>
	<tr><td>유형: &nbsp;&nbsp;&nbsp; 교직원 <input type="radio" name="ty" value="1"> 교수 <input type="radio" name="ty" value="2"> 학생 <input type="radio" name="ty" value="3"></td></tr>			
	<tr><td><input type="hidden" name="type" value="join"></td></tr>
		<tr><td><input type="button" onclick='test()' value='가입'/> <input type="reset" value="취소"></td></tr>
		
	</table>
	</form>
</body>
</html>