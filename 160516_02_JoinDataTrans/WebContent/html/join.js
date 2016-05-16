function OnclickEmailSelected(){
	var selectedEmail = document.getElementById("emailSelected").value;
	if(selectedEmail == "1"){
		document.form1.userEmail2.readOnly = false;
		document.form1.userEmail2.value = "";
		document.form1.userEmail2.focus();
	}else if(!selectedEmail == ""){
		document.form1.userEmail2.readOnly = true;
		document.getElementById("userEmail2").value=selectedEmail;
	}
}

function NullCheck(){
	var userId=document.getElementById("userId").value;
	var userPw=document.getElementById("userPw").value;
	var userPw2 = document.getElementById("userPw2").value;
	var userName=document.getElementById("userName").value;
	var userPhoneNumber=document.getElementById("userPhoneNumber").value;
	var userEmail=document.getElementById("userEmail1").value;
	var userEmail2=document.getElementById("userEmail2").value;
	var userInfoAssign=document.form1.userInfoAssign.value;
	
	if(userId==""){
		alert("아이디를 입력해주세요.");
		return false;
	}if(userPw==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}if (userName == "") {
		alert("이름을 입력 해주세요.");
		return false;		
	}if(userPhoneNumber == "") {
		alert("핸드폰 번호를 입력해주세요.");
		return false;
	}if (userEmail == "") {
		alert("이메일 주소를 입력하세요.");
		return false;
	}
	 else if(userEmail2 == ""){
		alert("이메일 주소를 다시 입력하세요.");
		document.form1.userEmail2.focus();
		return false;
	 }
	if (userInfoAssign == "false") {
		alert("동의 버튼을 클릭하지 않았습니다.");
		return false;
	}
	return true;
}

function passwordCheck(){
	var userPw=document.getElementById("userPw").value;
	var userPw2 = document.getElementById("userPw2").value;
	
	if(!(userPw == userPw2)){
		alert("비밀번호가 서로 다릅니다. 다시 입력하세요");
		document.getElementById("userPw").value="";
		document.getElementById("userPw2").value="";
		document.form1.userPw.focus();
		return false;
	}else{
		return true;
	}
}

function submit2(){
	if((this.NullCheck()==true) & (this.passwordCheck()==true)){
			document.form1.submit();
	}
	
}